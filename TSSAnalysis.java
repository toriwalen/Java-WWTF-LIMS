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
     * Records initial data for TSS analysis - the "tare weight" which is the weight of the fiberglass filter.
     * Also records sample volume - the amount of sample used for the analysis. 
     */
    public void startAnalysis(){
        System.out.println(sample.getLocation() + "-" + sample.getSampleNumber() +" sample");
        System.out.println("Enter sample volume (millileters):");
        setSampleVolume(scannerIn.nextDouble());
        System.out.println("Enter tare weight (grams):");
        setTareWeight(scannerIn.nextDouble());

    }
    public void startAnalysis(double sampleVolumeIn, double tareWeightIn){
        setSampleVolume(sampleVolumeIn);
        setTareWeight(tareWeightIn);

    }
/**
     * Records final data for TSS analysis - the "dry weight" of the filter plus the dried sample.
     */
    public void completeAnalysis(){
        System.out.println(sample.getLocation() + "-" + sample.getSampleNumber() +" sample");
        System.out.println("Enter dry weight (grams):");
        setDryWeight(scannerIn.nextDouble());
        this.calculateResult();
    }

    public void completeAnalysis(double netWeightIn){
        netWeight = netWeightIn;
        this.calculateResult();
    }

    private void calculateResult(){
        netWeight = dryWeight - tareWeight;
        result = (netWeight*1000)/(sampleVolume/1000); //converts net weight to miligrams and sample volume to liters
        //result is stored as milligrams per liter.
        sample.addToSampleLog("Total suspended solids result calculated: " + result + "mg/L");
        setAnalysisComplete(true);
    }

    public void setTareWeight(double weight){
        sample.addToSampleLog("TSS Filter tare weight recorded: " + weight + " g");
        tareWeight = weight;
    }

    public void setDryWeight(double weight){
        sample.addToSampleLog("TSS dry weight recorded: " + weight + " g");
        dryWeight = weight;
    }

    public double getTareWeight(){
        return tareWeight;
    }

    public double getDryWeight(){
        return dryWeight;
    }

    public void setSampleVolume(double volume){
        sample.addToSampleLog("TSS sample volume recorded: " + volume + " mL");
        sampleVolume = volume;
    }

    public double getSampleVolume(){
        return sampleVolume;
    }

    public String toString(){
        String toReturn = analysisName + " for sample " + sample.getSampleID();
        return toReturn;
    }

    public void calculateNetWeight(){
        if(tareWeight != -1 && dryWeight != -1){
            netWeight = tareWeight - dryWeight;
            sample.addToSampleLog("TSS net weight recorded: " + netWeight + " g");
        } else {
            System.out.println("Can not calculate net weight. Need tare and dry weights");
        }

    }
}
