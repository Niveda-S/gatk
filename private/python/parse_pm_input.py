#
# Generates BAM lists from Excel and TSV files provided by project managers.  Suitable for input into the pre-QC metrics generation
# script.
#
# To output a BAM list:
#   /humgen/gsa-hpprojects/software/bin/jython2.5.2/jython \
#     -J-classpath $STING_HOME/lib/poi-3.8-beta3.jar:$STING_HOME/lib/poi-ooxml-3.8-beta3.jar:$STING_HOME/lib/poi-ooxml-schemas-3.8-beta3.jar:$STING_HOME/lib/xmlbeans-2.3.0.jar:$STING_HOME/lib/dom4j-1.6.1.jar:$STING_HOME/lib/picard-1.48.889.jar:$STING_HOME/dist/GenomeAnalysisTK.jar \
#     parse_pm_input.py <input file.{xls|xlsx|txt|tsv}> true > <bam.list>
#
# To output a squid\tsample-formatted tsv
#   /humgen/gsa-hpprojects/software/bin/jython2.5.2/jython \
#     -J-classpath $STING_HOME/lib/poi-3.8-beta3.jar:$STING_HOME/lib/poi-ooxml-3.8-beta3.jar:$STING_HOME/lib/poi-ooxml-schemas-3.8-beta3.jar:$STING_HOME/lib/xmlbeans-2.3.0.jar:$STING_HOME/lib/dom4j-1.6.1.jar:$STING_HOME/lib/picard-1.48.889.jar:$STING_HOME/dist/GenomeAnalysisTK.jar \
#     parse_pm_input.py <input file.{xls|xlsx|txt|tsv}> false > <samples.tsv>
#
from java.io import FileInputStream

from net.sf.picard.io import IoUtil

import re,os,string,sys

import generate_per_sample_metrics

base_path = '/seq/picard_aggregation/%s/%s'

def excel_generator(filename):
    from org.apache.poi.ss.usermodel import Cell,Row,Sheet,Workbook,WorkbookFactory
    wb = WorkbookFactory.create(FileInputStream(filename));
    for sheet_number in range(wb.getNumberOfSheets()):
        project_column = None
        sample_column = None

        sheet = wb.getSheetAt(sheet_number);

        for cell in sheet.getRow(0):
            column_index = cell.getColumnIndex()
            column_contents = cell.getStringCellValue().strip()
            column_contents = re.sub('\\s+',' ',column_contents)
            if column_contents == 'Project':
                project_column = column_index
            if column_contents == 'External ID' or column_contents == 'Individual ID':
                sample_column = column_index

        if project_column != None and sample_column != None:
            for row_number in range(1,sheet.getLastRowNum()+1):
                project = sheet.getRow(row_number).getCell(project_column).getStringCellValue()
                if sheet.getRow(row_number).getCell(sample_column).getCellType() == Cell.CELL_TYPE_STRING:
                    sample = sheet.getRow(row_number).getCell(sample_column).getStringCellValue()
                elif sheet.getRow(row_number).getCell(sample_column).getCellType() == Cell.CELL_TYPE_NUMERIC:
                    sample = str(int(sheet.getRow(row_number).getCell(sample_column).getNumericCellValue()))
                else:
                    print >> sys.stderr, "Unable to parse sample column %d; row is of indecipherable type %s"%(sample_column,sheet.getRow(row_number).getCell(sample_column).getCellType())
                    continue
                yield project,sample
            return

def tsv_generator(filename):
    f = open(filename,'rU')
    for line in f:
        tokens =line.strip().split('\t')
        yield tokens
    f.close()    
        
def create_format_generator(filename):
    extension = os.path.splitext(filename)[1]
    if extension == '.xls' or extension == '.xlsx':
        return excel_generator(filename)
    elif extension == '.tsv' or extension == '.txt':
        return tsv_generator(filename)
    else:
        print 'Unrecognized file extension',extension
        sys.exit(1)

# Detects how xlses / tsvs should be parsed.
def project_file_reader(filename):
    generator = create_format_generator(filename)
    project_column = 0
    sample_column = 1
    first = True
    for entries in generator:
        if first:
            first = False
            # If only two columns exist and anything looks like a project, decide that this is a no-header format.
            if not (len(entries) == 2 and any([re.match('C([0-9])+',entry) for entry in entries])):
                # Didn't meet the simple two column no header format; try to locate the header columns
                project_column = None
                sample_column = None
                for i in range(len(entries)):
                    if entries[i].lower().find('project') >= 0:
                        project_column = i
                    elif 'external' in entries[i].lower() or 'individual' in entries[i].lower() or 'collaborator' in entries[i].lower():
                        sample_column = i
                # Verify that the columns were found.
                if project_column == None:
                    raise Exception('Unable to find project column; file was %s, columns were %s'%(filename,entries))
                if sample_column == None:
                    raise Exception('Unable to find sample column; file was %s, columns were %s'%(filename,entries))
                # Header parsed and understood; skip to the next row and start reading.
                continue
        project = entries[project_column]
        sample = entries[sample_column]
        latest_version = generate_per_sample_metrics.find_latest_version(project,sample)
        
        yield project,sample,latest_version

def main():
    if len(sys.argv) != 3:
        print 'USAGE: %s <input file.{xls|xlsx|tsv|txt}> <output as bam list>'
        sys.exit(1)
    if not os.path.exists(sys.argv[1]):
        print 'Input file %s not found' % sys.argv[1]
        sys.exit(1)

    input_filename = sys.argv[1]
    output_as_bam_list = sys.argv[2].lower() == 'true'

    for project,sample,latest_version in project_file_reader(input_filename):
        sample_filename = IoUtil.makeFileNameSafe(sample)        
        bam_file = '%s/v%d/%s.bam' % (base_path%(project,sample_filename),latest_version,sample_filename)
        if not os.path.exists(bam_file):
            print 'Malformed file: tried to find %s, but no such path exists' % bam_file
            sys.exit(1)

        if output_as_bam_list:
            print bam_file
        else:
            print string.join([project,sample],'\t')

if __name__ == "__main__":
    main()