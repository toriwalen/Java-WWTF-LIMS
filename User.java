import java.util.ArrayList;

/**
 * User is typically the laboratory technician. They take the samples and do the tests. 
 *
 * @author Tori
 * @version 20211213.1
 */
public class User
{
    // instance variables - replace the example below with your own
    private String initials;
    private String name;
    private ArrayList<String> userLog;
    
    /**
     * Constructor for objects of class User
     */
    public User()
    {
        
    }

    /**
     * Go sample records the time and datestamp of the beginning of a sampling event. 
     *
     * @param  none
     * @return    nothing - but should it return a Date?
     */
    public void goSample(){
        
        
    }
    /**
     * Record the datestamp of when they returned.
     * 
     * @param none
     * @return also none, but still considering returning a datestamp.
     */
    public void returnFromSampling(){
        
        chooseSamples();
    }
    /**
     * Eventually I would like to make this method work with drop down menus to choose samples, and check boxes for
     * the tests. The tests can be preassigned according to the config file. 
     * 
     * @param - none
     * @return - returns a SampleBatch
     */
    public SampleBatch chooseSamples(){
        SampleBatch todaysSamples = new SampleBatch();
        return todaysSamples;
    }
    /**
     * Use a txt file (fileIn) to create a batch of samples.
     * 
     * @param - file path to config.txt file. 
     * @return - returns a SampleBatch with Samples created for each line of the config file. Samples then instantiate Analyses.
     */
    public SampleBatch chooseSamples(String fileIn){
        SampleBatch todaysSamples = new SampleBatch(fileIn);
        return todaysSamples;
    }
    /**
     * Creates an AnalysisBatch
     * I honestly don't really know where I was going with this - I think I was going to make it so that
     * when there are two separate SampleBatches you can create an analysis batch from both.
     * @param
     * @return - batch
     */
    public Batch createAnalysisBatch(){
        // choose the analysis using buttons or something
        // creates new instance of the AnalysisBatch. 
        // Returns the chosen analysis
        // can be used within the startAnalysis method 
        return null;
    }
    /**
     * In the UI when the user clicks the "set test" button
     * this method will initiate the "analyzeBatch()" method from the passed in AnalysisBatch class.
     * @param - AnalysisBatch to be analyzed
     * @return - none
     */
    public void startAnalysis(Batch toAnalyze){
       
        }
       
        /**
         * User will call this method in the UI, and this method will initate the completeAnalysisBatch() method
         * from the passed in AnalysisBatch class.
         */
    public void completeAnalysis(Batch toAnalyze){
        
    }
    
    }

