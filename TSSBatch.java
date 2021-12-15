

import java.util.ArrayList;
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
    public void printBatchResults(){
        Node currentNode = head;
        System.out.println("Results for this batch of TSS samples");
        while(currentNode != null){
            TSSAnalysis toPrint = (TSSAnalysis)currentNode.getData();
            double result = toPrint.getResult();
            System.out.println("Sample " + toPrint.getSample().getSampleID() + " TSS result is " + result + " mg/L");
            currentNode = currentNode.getNextNode();
        }
    }
    public void startBatch(){
        Node currentNode = head;
        while(currentNode != null){
            TSSAnalysis toStart = (TSSAnalysis)currentNode.getData();
            toStart.startAnalysis();
            currentNode = currentNode.getNextNode();
        }
    }
    public void completeBatch(){
        Node currentNode = head;
        while(currentNode != null){
            TSSAnalysis toComplete = (TSSAnalysis)currentNode.getData();
            toComplete.completeAnalysis();
            currentNode = currentNode.getNextNode();
        }
    }
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
    public TSSBatch getBatch(){
        return this;
    }
    
/*
 * 

     public static void main(String args[]){
        
        //String samplingLocation, int sampleNumber, String collectionType, String sampleType, String analysisRequired
        Sample sample1 = new Sample(211214, 1, "MBR1", "grab", "TSS");
        Sample sample2 = new Sample(211214, 1, "PL-EFF", "composite", "TSS, BOD, ph, fecal coliform");
        Sample sample3 = new Sample(211214, 1, "PL-INF","composite",  "BOD, TSS");
        
        SampleBatch todaysSamples = new SampleBatch();
        todaysSamples.add(sample1);
        todaysSamples.add(sample3);
        todaysSamples.add(sample2);
        System.out.println(sample1.getTSSAnalysis().toString());
        TSSBatch todaysTSS = new TSSBatch(todaysSamples);
        //todaysTSS.print();
    } */
    
}


