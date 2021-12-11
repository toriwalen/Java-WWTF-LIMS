import java.util.ArrayList;
/**
 * This class creates objects representing Analysis performed on samples in a wastewater treatment facility.
 *
 * @author Tori
 * @version 2021-12-08
 */
public class Analysis
{
    protected Sample sample;
    private String sampleID;
    public final String analysisName;
    public final String method = "Test Method #123";
    private String analysisID;
    private int analysisDate; //date tested
    protected double result;
    private boolean analysisComplete = false;
    
    /**
     * Constructor for objects of class Analysis
     */
    public Analysis(Sample sample, String analysisName)
    {
       sampleID = sample.getSampleID();
       this.analysisName = analysisName;
       this.sample = sample;
       assignAnalysisID();
       sample.addToSampleLog("Added test: " + analysisName);
    }
    /**
     * This method is used for "setting" a test - recording the initial data for the test.
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void startAnalysis()
    {
        sample.addToSampleLog("Initial data recorded: ");
    }
    public void completeAnalysis(){
        sample.addToSampleLog("Final data recorded: ");
    }
    /**
     * This method is used for "reading" a test - recording the final data that will be used to calculate results.
     */
    public void readAnalysis(){
        
    }
    public String getSampleID(){
        return sampleID;
    }
    public String getName(){
        return analysisName;
    }
    private void assignAnalysisID(){
        this.analysisID = sampleID + analysisName;
    }
    /*
     * TO DO: make so that it lists old and new data
     */
    public void fixTypo(){
        sample.addToSampleLog("Typo fixed. X entry was changed to X");
    }
    public String toString(){
        String description = analysisName +" " + method;
        return description;
    }
    public void print(){
        System.out.println("Sample " + sample.getSampleID() + " " + analysisName + " test");
    }
    public Sample getSample(){
        return sample;
    }
}
