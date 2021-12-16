import java.util.Scanner;

/**
 * This analysis is for Total Suspended Solids
 *
 * @author Tori
 * @version 20211209.1
 */
public class TSSAnalysis extends Analysis
{
    public final String analysisName = "Total Suspended Solids";
    public final String methodID = "SM 2540 D";
    private double tareWeight = -1; //grams
    private double dryWeight = -1; //grams
    private double netWeight; //grams - calculated by subtracting the tare weight (weight of the filter paper) from the dried weight.
    //I know I should be saying mass instead of weight but I went with weight.
    private double sampleVolume; //millileters
    private double result; //mg per liter

    Scanner scannerIn = new Scanner(System.in);
    /**
     * Constructor for objects of class TSSAnalysis
     */
    public TSSAnalysis(Sample sample)
    {
        // initialise instance variables
        super(sample, "Total Suspended Solids");
    }

    /**
     * Uses scanner
     * Records initial data for TSS analysis - the "tare weight" which is the weight of the fiberglass filter.
     * Also records sample volume - the amount of sample used for the analysis. 
     * 
     * @param - none, but scanners are involved
     * @return - none
     */
    public void startAnalysis(){
        System.out.println(sample.getLocation() + "-" + sample.getSampleNumber() +" sample");
        System.out.println("Enter sample volume (millileters):");
        setSampleVolume(scannerIn.nextDouble());
        System.out.println("Enter tare weight (grams):");
        setTareWeight(scannerIn.nextDouble());

    }

    /**
     * Records initial data for TSS analysis - tare weight and sample volume.
     * Requires the values to be passed in as parameters to the method.
     * 
     * @param - two doubles - the sample volume used and the "tare weight" aka the mass of the filter being used.
     * @return - none
     */
    public void startAnalysis(double sampleVolumeIn, double tareWeightIn){
        setSampleVolume(sampleVolumeIn);
        setTareWeight(tareWeightIn);

    }

    /**
     * Uses scanner
     * Records final data for TSS analysis - the "dry weight" of the filter plus the dried sample.
     * 
     * @param - none but a scanner is used
     * @return - none
     */
    public void completeAnalysis(){
        System.out.println(sample.getLocation() + "-" + sample.getSampleNumber() +" sample");
        System.out.println("Enter dry weight (grams):");
        setDryWeight(scannerIn.nextDouble());
        this.calculateResult();
    }
    
    /**
     * Requires the dry weight of the filter and sample to be passed into the method.
     * Sets the dry weight and calculates the final TSS result in mg/L
     * 
     * @param - one double - the mass of the dried product + filter
     * @return - none
     */
    public void completeAnalysis(double dryWeightIn){
        setDryWeight(dryWeightIn);
        this.calculateResult();
    }

    /**
     * Calculates final TSS result in mg/L
     * 
     * @param - none
     * @return - none
     */
    public void calculateResult(){
        calculateNetWeight();
        result = (netWeight*1000)/(sampleVolume/1000); //converts net weight to miligrams and sample volume to liters
        //result is stored as milligrams per liter.
        sample.addToSampleLog("Total suspended solids result calculated: " + result + "mg/L");
        setAnalysisComplete(true);
    }

    /**
     * Setter for the tare weight - also adds to the sample log.
     * 
     * @param - one double - the mass of the filter to be used for TSS analysis.
     * @return - none
     */
    public void setTareWeight(double weight){
        sample.addToSampleLog("TSS Filter tare weight recorded: " + weight + " g");
        tareWeight = weight;
    }

    /**
     * Setter for the dry weight - also adds to the sample log.
     * 
     * @param - one double - the mass of the filter and dried sample
     * @return - none
     */
    public void setDryWeight(double weight){
        sample.addToSampleLog("TSS dry weight recorded: " + weight + " g");
        dryWeight = weight;
    }

    /**
     * Accessor method for the tare weight.
     * 
     * @param - none
     * @return - double - initial weight of the filter used for analysis.
     */
    public double getTareWeight(){
        return tareWeight;
    }

    /**
     * Accessor method for the dry weight.
     * 
     * @param - none
     * @return - double - final weight of the filter and sample analyzed.
     */
    public double getDryWeight(){
        return dryWeight;
    }

    /**
     * Setter method for the sample volume
     * 
     * @param - one double, the volume of sample being analyzed
     * @return - none
     */
    public void setSampleVolume(double volume){
        sample.addToSampleLog("TSS sample volume recorded: " + volume + " mL");
        sampleVolume = volume;
    }

    /**
     * Accessor method for the sample volume.
     * 
     * @param - none
     * @return - double - volume of sample that was analyzed.
     */
    public double getSampleVolume(){
        return sampleVolume;
    }

    /**
     * Accessor method for the result
     * 
     * @param - none
     * @return - double, the result of the analysis.
     */
    public double getResult(){
        return result;
    }

    /**
     * To string method - I would like to rework this so that there is more information IE results, sampleID etc.
     * 
     * @param - none
     * @return - string describing analysis
     */
    public String toString(){
        String toReturn = analysisName + " for sample " + sample.getSampleID();
        return toReturn;
    }
    
    /**
     * This method is used to calculate the net weight for a sample, which is the actual mass of sample without the filter.
     * Should I make it return the net weight instead of being a void method?
     * 
     * @param - none
     * @return - none
     */
    private void calculateNetWeight(){
        if(tareWeight != -1 && dryWeight != -1){
            netWeight = dryWeight - tareWeight;
            sample.addToSampleLog("TSS net weight recorded: " + netWeight + " g");
        } else {
            System.out.println("Can not calculate net weight. Need tare and dry weights");
        }

    }

}
