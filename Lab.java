
/**
 * Write a description of class Lab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Lab
     */
    public Lab()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    public static void main(String[] args){
        //int samplingDate, int sampleNumber, String samplingLocation, String sampleType, String analysissRequired
        Sample sample1 = new Sample(20211209, 1, "MBR1", "grab", "TSS");
        Sample sample2 = new Sample(20211209, 1, "permeate", "composite", " BOD, pH, fecal coliform");
        Sample sample3 = new Sample(20211204, 1, "influent", "composite", "TSS, BOD, DO");
        Sample sample4 = new Sample(20211204, 1, "effluent", "composite", "TSS, BOD, DO");
        //System.out.println(sample1.getSampleID());
        SampleBatch todaysSamples = new SampleBatch();
        todaysSamples.addToBatch(sample1);
        todaysSamples.addToBatch(sample2);
        todaysSamples.addToBatch(sample3);
        todaysSamples.addToBatch(sample4);
        //todaysSamples.print();
        //System.out.println(sample3.equals(sample4));
        //System.out.println(sample2.equals(sample4));
        //TSSAnalysis sample2TSS = new TSSAnalysis(sample2);
        //sample2TSS.print();
        //sample2TSS.startAnalysis();
        //sample2TSS.completeAnalysis();
        //System.out.println("Sample " + sample2TSS.getSampleID() + " TSS result is " + sample2TSS.getResult() + " mg/L");
        //sample2.viewSampleLog();
        TSSBatch todaysTSSBatch = new TSSBatch(todaysSamples);
        todaysTSSBatch.startAnalysisBatch();
        todaysTSSBatch.completeAnalysisBatch();
        todaysTSSBatch.printBatchResults();
        //sample2.viewAnalysisList();
    }
}
