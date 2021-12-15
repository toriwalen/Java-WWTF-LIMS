import java.util.ArrayList;
/**
 * This class creates objects representing Analysis performed on samples in a wastewater treatment facility.
 *
 * @author Tori
 * @version 20211208.1
 */
public class Analysis
{
    protected Sample sample;
    private String analysisID;
    private int analysisDate; //date tested
    public final String analysisName;
    public final String method = "Test Method #123";
    private double result;
    private boolean analysisComplete = false;
    
    /**
     * Constructor for objects of class Analysis
     */
    public Analysis(Sample sample, String analysisName)
    {
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
    public String getName(){
        return analysisName;
    }
    /**
     * This method is used for "reading" a test - recording the final data that will be used to calculate results.
     */
    public void completeAnalysis(){
        sample.addToSampleLog("Final data recorded: ");
    }
    private double calculateResult(){
        return result;
    }
    public String getAnalysisID(){
        return analysisID;
    }
    public int getAnalysisDate(){
        return analysisDate;
    }
    public boolean isComplete(){
        return analysisComplete;
    }
    public String getAnalysisName(){
        return analysisName;
    }
    public double getResult(){
        return result;
    }
    public String getMethod(){
        return method;
    }
    private void assignAnalysisID(){
        this.analysisID = "TSS" + sample.getSampleID();
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
    public void setAnalysisComplete(boolean isComplete){
        analysisComplete = isComplete;
    }
}
