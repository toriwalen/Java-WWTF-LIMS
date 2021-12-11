import java.util.Scanner;

/**
 * This analysis is for Total Suspended Solids
 *
 * @author Tori
 * @version 20211209
 */
public class TSSAnalysis extends Analysis
{
    public final String analysisName = "Total Suspended Solids";
    public final String methodID = "SM 2540 D";
    private double tareWeight; //grams
    private double dryWeight; //grams
    private double netWeight; //grams
    private double sampleVolume; //millileters
    private int ovenTempIn; //degrees C
    private int ovenTempOut; //degrees C
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
    public void startAnalysis(){
        System.out.println(sample.getLocation() + "-" + sample.getSampleNumber() +" sample");
        System.out.println("Enter tare weight (grams):");
        tareWeight = scannerIn.nextDouble();
        sample.addToSampleLog("TSS Filter tare weight recorded:" + tareWeight + "g");
        System.out.println("Enter sample volume (millileters):");
        sampleVolume = scannerIn.nextDouble();
        sample.addToSampleLog("Sample volume recorded:" + sampleVolume + "mL.");
        
    }
    public void completeAnalysis(){
        System.out.println(sample.getLocation() + "-" + sample.getSampleNumber() +" sample");
        System.out.println("Enter dry weight (grams):");
        dryWeight = scannerIn.nextDouble();
        sample.addToSampleLog("Dry weight recorded: " + dryWeight + "g");
        this.calculateTotalSuspendedSolids();
    }
    private void calculateTotalSuspendedSolids(){
        netWeight = dryWeight - tareWeight;
        result = (netWeight*1000)/(sampleVolume/1000); //converts net weight to miligrams and sample volume to liters
        //result is stored as milligrams per liter.
        sample.addToSampleLog("Total suspended solids result calculated: " + result + "mg/L");
    }
    public int getResult(){
        return (int)result;
    }
}
