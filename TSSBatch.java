
import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class creates batches of Analysis objects.
 *
 * @author Tori
 * @version 20211210.1
 */
public class TSSBatch
{
    private Node head = null;
    private int dateCreated;
    private int ovenTempIn;
    private int ovenTempOut;
    private int timeIn;
    private int timeOut;
    
    Sample blank = new Sample(20211210, 1, "blank", "blank", "Total Suspended Solids");
    Sample control = new Sample(20211210, 1, "control", "control", "Total Suspended Solids");
    //int samplingDate, int sampleNumber, String samplingLocation, String sampleType, String analysissRequired
    public TSSBatch(SampleBatch sampleBatch){
        //add blank and control to tssbatch
        //for each node in sample batch, have the sample return the tssanalysis object associated with it.
        //add these tssanalysis objects to the tssbatch
        this.add(blank.getTSSAnalysis());
        this.add(control.getTSSAnalysis());
        Node currentNode = sampleBatch.getHeadNode();
        Sample sampleInNode;
        if(currentNode == null){
            System.out.println("No samples in the sample batch");
        } else {
            while(currentNode != null){
                sampleInNode =  (Sample)currentNode.getData();
                if(sampleInNode.hasTSSAnalysis()){
                    add(sampleInNode.getTSSAnalysis());
                } else {
                    System.out.println(sampleInNode.getSampleID() + " does not have a TSS analysis to add to this batch");
                }
                currentNode = currentNode.getNextNode();
            }
        }
    
    }
    /**
     * Add a TSSAnalysis to the end of the batch. 
     * WHERE DOES getAnalysisID() LIVE>!??!?!?!
     * 
     * @param - requires a TSSAnalysis to be passed in.
     * @return - none
     */
    public void add(TSSAnalysis analysisIn){
        Node currentNode = head;
        if(head == null){
            this.head = new Node(analysisIn);
            System.out.println("added analysis " + analysisIn.getAnalysisID() + " to TSS batch");
        }else{
            
                while(currentNode.hasNext()){
                currentNode = currentNode.getNextNode();  
            }
                    currentNode.setNextNode(new Node(analysisIn));
                    System.out.println("added analysis " + analysisIn.getAnalysisID() + " to TSS batch");
                }
    }
    /**
     * Print results from this batch of analyses.
     * 
     * @param - none
     * @return - none
     */
    public void printBatchResults(){
        Node currentNode = head;
        BigDecimal bigDecimal;
        System.out.println("Results for this batch of TSS analyses");
        while(currentNode != null){
            TSSAnalysis toPrint = (TSSAnalysis)currentNode.getData();
            double result = toPrint.getResult();
            bigDecimal = new BigDecimal(result);
            bigDecimal = bigDecimal.setScale(0, RoundingMode.HALF_UP);
            System.out.println("Sample " + toPrint.getSample().getSampleID() + " TSS result is " + bigDecimal.doubleValue() + " mg/L");
            currentNode = currentNode.getNextNode();
        }
    }
    /**
     * Uses scanner
     * Record only the tareWeights for the whole batch of analyses.
     * 
     * @param - none
     * @return - none
     */
    private void recordTareWeights(){
        Node currentNode = head;
        Scanner scannerIn = new Scanner(System.in);
        while(currentNode != null){
            TSSAnalysis toStart = (TSSAnalysis)currentNode.getData();
            System.out.println("Tare weight for sample " + toStart.getSample().getLocation() + "-" + toStart.getSample().getSampleNumber());
            toStart.setTareWeight(scannerIn.nextDouble());
            currentNode = currentNode.getNextNode();
        }
    }
    /**
     * Uses Scanner
     * Record only the sampleVolumes for the whole batch of analyses.
     * 
     * @param - none
     * @return - none
     */
    private void recordSampleVolumes(){
        Node currentNode = head;
        Scanner scannerIn = new Scanner(System.in);
        while(currentNode != null){
            TSSAnalysis toStart = (TSSAnalysis)currentNode.getData();
            System.out.println("Sample volume for sample " + toStart.getSample().getLocation() + "-" + toStart.getSample().getSampleNumber());
            toStart.setSampleVolume(scannerIn.nextDouble());
            currentNode = currentNode.getNextNode();
        }
    }
    /**
     * Uses Scanner
     *Record only the dryWeights for the whole batch of analyses.
     * 
     * @param - none
     * @return - none
     */
    private void recordDryWeights(){
        Node currentNode = head;
        Scanner scannerIn = new Scanner(System.in);
        while(currentNode != null){
            TSSAnalysis toStart = (TSSAnalysis)currentNode.getData();
            System.out.println("Dry weight for sample " + toStart.getSample().getLocation() + "-" + toStart.getSample().getSampleNumber());
            toStart.setDryWeight(scannerIn.nextDouble());
            currentNode = currentNode.getNextNode();
        }
    }
    
    /**
     * Iterates through the analyses in the batch and calls the calculateResult() method for each one. 
     * @param - none
     * @return - none
     */
    private void calculateBatchResults(){
        Node currentNode = head;
        Scanner scannerIn = new Scanner(System.in);
        while(currentNode != null){
            TSSAnalysis toStart = (TSSAnalysis)currentNode.getData();
            toStart.calculateResult();
            currentNode = currentNode.getNextNode();
        }
    }
    
    /**
     * Initializes analysis of the batch. First the user records all of the tareWeights for the analyses.
     * Then they record all of the sample volumes.
     * 
     * @param - none
     * @return - none
     */
    public void startBatch(){
        recordTareWeights();
        recordSampleVolumes();
    }
    
    /**
     * Completes analysis of the batch - User records all of the dry weights and results are automatically calculated.
     * 
     * @param - none
     * @return - none
     */
    public void completeBatch(){
        recordDryWeights();
        calculateBatchResults();
    }
    
    /**
     * Prints a list of analysis IDs 
     * Where does getAnalysisID come from?? Analysis?? probably.
     * 
     * @param - none
     * @return - none
     */
    public void print(){
        Node currentNode = head;
        System.out.println("analysis IDs for this batch");
            while(currentNode != null){
                TSSAnalysis toPrint = (TSSAnalysis)currentNode.getData();
                String location = toPrint.getSample().getLocation();
                int sampleNumber = toPrint.getSample().getSampleNumber();
                System.out.println("TSS Analysis ID " + toPrint.getAnalysisID() + " is assigned to sample " + location + "_" + sampleNumber);
                currentNode = currentNode.getNextNode();
            }
    }
    
    /**
     * I'm not really sure when I would use this to be honest. Maybe in a situation where the TSS batch was not explicitly
     * initialized by me and theres no other way to access it??
     * 
     * @param - none
     * @return - this TSSBatch
     */
    public TSSBatch getBatch(){
        return this;
    }
    
}


