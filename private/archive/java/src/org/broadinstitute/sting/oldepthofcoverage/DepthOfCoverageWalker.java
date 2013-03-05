/*
*  By downloading the PROGRAM you agree to the following terms of use:
*  
*  BROAD INSTITUTE - SOFTWARE LICENSE AGREEMENT - FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
*  
*  This Agreement is made between the Broad Institute, Inc. with a principal address at 7 Cambridge Center, Cambridge, MA 02142 (BROAD) and the LICENSEE and is effective at the date the downloading is completed (EFFECTIVE DATE).
*  
*  WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
*  WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
*  NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
*  
*  1. DEFINITIONS
*  1.1 PROGRAM shall mean copyright in the object code and source code known as GATK2 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute/GATK on the EFFECTIVE DATE.
*  
*  2. LICENSE
*  2.1   Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. 
*  The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only.  For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
*  2.2  No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD.  LICENSEE shall ensure that all of its users agree to the terms of this Agreement.  LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
*  2.3  License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.  
*  
*  3. OWNERSHIP OF INTELLECTUAL PROPERTY 
*  LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies.  LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
*  Copyright 2012 Broad Institute, Inc.
*  Notice of attribution:  The GATK2 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
*  LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
*  
*  4. INDEMNIFICATION
*  LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
*  
*  5. NO REPRESENTATIONS OR WARRANTIES
*  THE PROGRAM IS DELIVERED AS IS.  BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
*  IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
*  
*  6. ASSIGNMENT
*  This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
*  
*  7. MISCELLANEOUS
*  7.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
*  7.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
*  7.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
*  7.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested.  All notices under this Agreement shall be deemed effective upon receipt. 
*  7.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter. 
*  7.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
*  7.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.sting.gatk.walkers.coverage;

import org.broadinstitute.sting.gatk.walkers.*;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.utils.cmdLine.Argument;
import org.broadinstitute.sting.utils.*;
import org.broadinstitute.sting.utils.pileup.*;
import net.sf.samtools.SAMReadGroupRecord;
import org.broadinstitute.variant.utils.BaseUtils;

import java.util.*;

/**
 * Computes the depth of coverage at all loci in the specified region of the reference.  Includes features to control
 * grouping of results by read group or by sample, or filtering loci with either a small number of overlapping alignments
 * or with alignments of poor mapping quality.  Can optionally include individual base counts at each locus. 
 */
@By(DataSource.REFERENCE)
public class DepthOfCoverageWalker extends LocusWalker<DepthOfCoverageWalker.DoCInfo, DepthOfCoverageWalker.DoCInfo> {

    @Argument(fullName="suppressLocusPrinting", shortName= "noLocus", doc="Suppress printing", required=false)
    public boolean suppressLocusPrinting = false;

    @Argument(fullName="suppressIntervalPrinting", shortName= "noInterval", doc="Suppress printing", required=false)
    public boolean suppressIntervalPrinting = false;

    @Argument(fullName="printBaseCounts", shortName ="bases", doc="Print individual base counts (A,C,G,T only)", required=false)
    protected boolean printBaseCounts = false;

    @Argument(fullName="minMAPQ", shortName ="minMAPQ", doc="If provided, we will also list read counts with MAPQ >= this value at a locus in coverage",required=false)
    protected int excludeMAPQBelowThis = -1;

    @Argument(fullName = "minBaseQualityScore", shortName = "mbq", doc = "Minimum base quality required to consider a base for calling", required = false)
    public Integer minBaseQ = -1;

    @Argument(fullName="minDepth", shortName ="minDepth", doc="If provided, we will also list the percentage of loci with depth >= this value per interval",required=false)
    protected int minDepthForPercentage = -1;

    @Argument(fullName="byReadGroup", shortName="byRG", doc="List read depths for each read group")
    protected boolean byReadGroup = false;

    @Argument(fullName="bySample", shortName="bySample", doc="List read depths for each sample")
    protected boolean bySample = false;

    @Argument(fullName="printHistogram", shortName="histogram", doc="Print a histogram of the coverage")
    protected boolean printHistogram = false;


    // keep track of the read group and sample names
    private TreeSet<String> readGroupNames = new TreeSet<String>();
    private TreeSet<String> sampleNames = new TreeSet<String>();

    // keep track of the histogram data
    private ExpandingArrayList<Long> coverageHist = null;
    private long maxDepth = 0;
    private long totalLoci = 0;

    // we want to see reads with deletions
    public boolean includeReadsWithDeletionAtLoci() { return true; }

    public void initialize() {

        // initialize histogram array
        if ( printHistogram ) {
            coverageHist = new ExpandingArrayList<Long>();
        }

        // initialize read group names from BAM header
        if ( byReadGroup ) {
            List<SAMReadGroupRecord> readGroups = this.getToolkit().getSAMFileHeader().getReadGroups();
            for ( SAMReadGroupRecord record : readGroups )
                readGroupNames.add(record.getReadGroupId());
        }

        // initialize sample names from BAM header
        if ( bySample ) {
            List<SAMReadGroupRecord> readGroups = this.getToolkit().getSAMFileHeader().getReadGroups();
            for ( SAMReadGroupRecord record : readGroups ) {
                String sample = record.getSample();
                if ( sample != null )
                    sampleNames.add(sample);
            }
        }

        // build and print the per-locus header
        if ( !suppressLocusPrinting ) {
            out.println("\nPER_LOCUS_COVERAGE_SECTION");
            printHeaderLine(false);
        }
    }

    public DoCInfo map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {

        // fill in and print all of the per-locus coverage data, then return it to reduce

        ReadBackedPileup pileup = context.getPileup().getBaseFilteredPileup(minBaseQ);

        DoCInfo info = new DoCInfo();
        info.totalCoverage = pileup.size();

        long nBadMAPQReads = 0, nDeletionReads = 0;
        for ( PileupElement p : pileup ) {

            if ( excludeMAPQBelowThis > 0 && p.getRead().getMappingQuality() < excludeMAPQBelowThis )
                nBadMAPQReads++;
            else if ( p.isDeletion() )
                nDeletionReads++;

            if ( printBaseCounts ) {
                int baseIndex = BaseUtils.simpleBaseToBaseIndex(p.getBase());
                if ( baseIndex != -1 )
                    info.baseCounts[baseIndex]++;
            }

            SAMReadGroupRecord readGroup = p.getRead().getReadGroup();
            if ( readGroup == null )
                continue;

            if ( byReadGroup ) {
                String readGroupName = readGroup.getReadGroupId();
                long oldDepth = info.depthByReadGroup.get(readGroupName);
                info.depthByReadGroup.put(readGroupName, oldDepth + 1);
            }

            if ( bySample ) {
                String sample = readGroup.getSample();
                if ( sample != null ) {
                    long oldDepth = info.depthBySample.get(sample);
                    info.depthBySample.put(sample, oldDepth + 1);
                }
            }
        }

        info.numDeletions = nDeletionReads;
        if ( excludeMAPQBelowThis > 0 )
            info.numBadMQReads = nBadMAPQReads;

        // if we need to print the histogram, fill in the data
        if ( printHistogram )
            incCov(info.totalCoverage);

        if ( !suppressLocusPrinting )
            printDoCInfo(context.getLocation(), info, false);

        return info;
    }

    public boolean isReduceByInterval() {
        return true;
    }

    public DoCInfo reduceInit() { return new DoCInfo(); }

    public DoCInfo reduce(DoCInfo value, DoCInfo sum) {

        // combine all of the per-locus data for a given interval

        sum.totalCoverage += value.totalCoverage;
        sum.numDeletions += value.numDeletions;
        sum.numBadMQReads += value.numBadMQReads;
        if ( value.totalCoverage >= minDepthForPercentage ) {
            sum.minDepthCoveredLoci++;
        }
        if ( printBaseCounts ) {
            for (int baseIndex = 0; baseIndex < BaseUtils.BASES.length; baseIndex++ )
                sum.baseCounts[baseIndex] += value.baseCounts[baseIndex];
        }
        if ( byReadGroup ) {
            for ( String rg : readGroupNames ) {
                long oldDepth = sum.depthByReadGroup.get(rg);
                sum.depthByReadGroup.put(rg, oldDepth + value.depthByReadGroup.get(rg));
            }
        }
        if ( bySample ) {
            for ( String sample : sampleNames ) {
                long oldDepth = sum.depthBySample.get(sample);
                sum.depthBySample.put(sample, oldDepth + value.depthBySample.get(sample));
            }
        }

        return sum;
    }

    @Override
    public void onTraversalDone(List<Pair<GenomeLoc, DoCInfo>> results) {

        // build and print the per-interval header
        if ( ! suppressIntervalPrinting ) {
            out.println("\n\nPER_INTERVAL_COVERAGE_SECTION");
            printHeaderLine(true);

            // print all of the individual per-interval coverage data
            for ( Pair<GenomeLoc, DoCInfo> result : results )
                printDoCInfo(result.first, result.second, true);
        }

        // if we need to print the histogram, do so now
        if ( printHistogram )
            printHisto();
    }

    private void printHeaderLine(boolean printAverageCoverage) {
        StringBuilder header = new StringBuilder("location\ttotal_coverage");
        if ( printAverageCoverage )
            header.append("\taverage_coverage");
        header.append("\tcoverage_without_deletions");
        if ( printAverageCoverage )
            header.append("\taverage_coverage_without_deletions");
        if ( excludeMAPQBelowThis > 0 ) {
            header.append("\tcoverage_atleast_MQ");
            header.append(excludeMAPQBelowThis);
            if ( printAverageCoverage ) {
                header.append("\taverage_coverage_atleast_MQ");
                header.append(excludeMAPQBelowThis);
            }
        }
        if ( printAverageCoverage && minDepthForPercentage >= 0 ) {
            header.append("\tpercent_loci_covered_atleast_depth");
            header.append(minDepthForPercentage);
        }
        if ( printBaseCounts ) {
            header.append("\tA_count\tC_count\tG_count\tT_count");
        }
        if ( byReadGroup ) {
            for ( String rg : readGroupNames ) {
                header.append("\tcoverage_for_");
                header.append(rg);
            }
        }
        if ( bySample ) {
            for ( String sample : sampleNames ) {
                header.append("\tcoverage_for_");
                header.append(sample);
            }
        }
        out.println(header.toString());
    }

    private void incCov(long depth) {
        long c = coverageHist.expandingGet((int)depth, 0L);
        coverageHist.set((int)depth, c + 1);
        if ( depth > maxDepth )
            maxDepth = depth;
        totalLoci++;
    }

    private long getCov(long depth) {
        return coverageHist.get((int)depth);
    }

    private void printHisto() {

        // sanity check
        if ( totalLoci == 0 )
            return;

        // Code for calculting std devs adapted from Michael Melgar's python script

        // Find the maximum extent of 'good' data
        // First, find the mode
        long maxValue = getCov(1); // ignore doc=0
        int mode = 1;
        for (int i = 2; i <= maxDepth; i++) {
            if ( getCov(i) > maxValue ) {
                maxValue = getCov(i);
                mode = i;
            }
        }

        // now, procede to find end of good Gaussian fit
        long dist = (long)Math.pow(10, 9);
        while ( Math.abs(getCov(mode) - getCov(1)) < dist && mode < maxDepth )
            dist = Math.abs(getCov(mode++) - getCov(1));
        long maxGoodDepth = Math.min(mode + 1, maxDepth);

        // calculate the mean of the good region
        long totalGoodSites = 0, totalGoodDepth = 0;
        for (int i = 1; i <= maxGoodDepth; i++) { // ignore doc=0
            totalGoodSites += getCov(i);
            totalGoodDepth += i * getCov(i);
        }
        double meanGoodDepth = (double)totalGoodDepth / (double)totalGoodSites;

        // calculate the variance and standard deviation of the good region
        double var = 0.0;
        for (int i = 1; i <= maxGoodDepth; i++) {  // ignore doc=0
            var += getCov(i) * Math.pow(meanGoodDepth - (double)i, 2);
        }
        double stdev = Math.sqrt(var / (double)totalGoodSites);

        // print
        out.println("\n\nHISTOGRAM_SECTION");
        out.printf("# sites within Gaussian fit  : mean:%f num_sites:%d std_dev:%f%n", meanGoodDepth, totalGoodSites, stdev);

        for (int i = 1; i <= 5; i++)
            out.printf("# Gaussian mean + %d Std Dev  : %f%n", i, (meanGoodDepth + i*stdev));

		out.println("\ndepth count freq(percent)");
		for (int i = 0; i <= maxDepth; i++)
			out.printf("%d %d %f\n", i, getCov(i), (100.0*getCov(i)) / (double)totalLoci);
    }

    private void printDoCInfo(GenomeLoc loc, DoCInfo info, boolean printAverageCoverage) {

        double totalBases = (double)(loc.getStop() - loc.getStart() + 1);

        StringBuilder sb = new StringBuilder();
        sb.append(loc);
        sb.append("\t");
        sb.append(info.totalCoverage);
        sb.append("\t");
        if ( printAverageCoverage ) {
            sb.append(String.format("%.2f", ((double)info.totalCoverage) / totalBases));
            sb.append("\t");
        }
        sb.append((info.totalCoverage - info.numDeletions));

        if ( printAverageCoverage ) {
            sb.append("\t");
            sb.append(String.format("%.2f", ((double)(info.totalCoverage - info.numDeletions)) / totalBases));
        }

        if ( excludeMAPQBelowThis > 0 ) {
            sb.append("\t");
            sb.append((info.totalCoverage - info.numBadMQReads));
            if ( printAverageCoverage ) {
                sb.append("\t");
                sb.append(String.format("%.2f", ((double)(info.totalCoverage - info.numBadMQReads)) / totalBases));
            }
        }

        if ( printAverageCoverage && minDepthForPercentage >= 0 ) {
            sb.append("\t");
            sb.append(String.format("%.2f", ((double)info.minDepthCoveredLoci) / totalBases));            
        }

        if ( printBaseCounts ) {
            for (int baseIndex = 0; baseIndex < BaseUtils.BASES.length; baseIndex++ ) {
                sb.append("\t");
                sb.append(String.format("%8d", info.baseCounts[baseIndex]));
            }
        }

        if ( byReadGroup ) {
            for ( String rg : readGroupNames ) {
                sb.append("\t");
                sb.append(String.format("%8d", info.depthByReadGroup.get(rg)));
            }
        }

        if ( bySample ) {
            for ( String sample : sampleNames ) {
                sb.append("\t");
                sb.append(String.format("%8d", info.depthBySample.get(sample)));
            }
        }

        out.println(sb.toString());
    }

    public class DoCInfo {
        public long totalCoverage = 0;
        public long numDeletions = 0;
        public long numBadMQReads = 0;
        public long minDepthCoveredLoci = 0;

        public long[] baseCounts = null;

        public HashMap<String, Long> depthByReadGroup = null;
        public HashMap<String, Long> depthBySample = null;

        public DoCInfo() {
            if ( printBaseCounts ) {
                baseCounts = new long[4];
            }
            if ( byReadGroup ) {
                depthByReadGroup = new HashMap<String, Long>();
                for ( String readGroupName : readGroupNames )
                    depthByReadGroup.put(readGroupName, 0L);
            }
            if ( bySample ) {
                depthBySample = new HashMap<String, Long>();
                for ( String sample : sampleNames )
                    depthBySample.put(sample, 0L);
            }
        }

        @Override
        public String toString() {
            // This is an executive summary, included mainly so that integration tests will pass.
            // TODO: Add a more compelling summary.
            return String.format("Summary: total coverage = %d; # of deletions = %d; # of bad mapping quality reads = %d; minimum covered depth =%d",
                    totalCoverage,
                    numDeletions,
                    numBadMQReads,
                    minDepthCoveredLoci);    
        }

    }
}