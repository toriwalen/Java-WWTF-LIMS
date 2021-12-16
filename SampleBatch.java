import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A sample batch is considered to be all samples taken during one sampling "event" - a period of time where samples are 
 * taken in quick succession from multiple locations around the plant. 
 *
 * @author Tori
 * @version 20211209.1
 */
public class SampleBatch
{
    protected Node head;
    protected int dateCreated;

    /**
     * Default constructor with first sample in. Date is a placeholder for now.
     */
    public SampleBatch(Sample firstSample){
        head = new Node(firstSample);
        dateCreated = 20211209;
    }

    public SampleBatch(){
        head = null;
        System.out.println("Sample batch created");
        dateCreated = 20211214;
    }

    /**
     * Create a constructor for a config file. While the file has next line, create new samples from the info in the file.
     */
    public SampleBatch(String fileName){

        try {
            File fileIn = new File(fileName);
            Scanner sc = new Scanner(fileIn);
            String firstLine = sc.nextLine();
            while(sc.hasNext()){
                String samplingLocation = sc.next();
                int sampleNumber = Integer.parseInt(sc.next());
                String sampleType = sc.next();
                String analysisRequired = sc.nextLine();
                Sample newSample = new Sample(samplingLocation, sampleNumber, sampleType, analysisRequired);
                add(newSample);
                newSample.viewAnalysisList();
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
    public void insert(Sample toInsert, int position){
    }
    public void add(Sample sampleIn){
        Node currentNode = head;
        if(head == null){
            head = new Node(sampleIn);
            System.out.println("added sample " + sampleIn.getSampleID() + " to batch");
        }else{

            while(currentNode.hasNext()){
                currentNode = currentNode.getNextNode();  
            }
            currentNode.setNextNode(new Node(sampleIn));
            System.out.println("added sample " + sampleIn.getSampleID() + " to batch");
        }

    }


    
    /**
     * Prints sample IDs of samples in the batch
     * 
     * @param - none
     * @return - none
     */
    public void print(){
        Node currentNode = head;
        while(currentNode != null){
            Sample toPrint = (Sample)currentNode.getData();
            System.out.println(toPrint.getSampleID());
            currentNode = currentNode.getNextNode();
        }

    }

    public String toString(){
        String toReturn = "";
        Node currentNode = head;
        while(currentNode != null){
            Sample toPrint = (Sample)currentNode.getData();
            toReturn += toPrint.toString() + "\n";
            currentNode = currentNode.getNextNode();
        }
        return toReturn;
    }

    public Node remove(String sampleID){
        Node currentNode = head;
        Node previousNode = currentNode;
        Node toRemove = null;
        while(currentNode != null){      
            Sample toCheck = (Sample)currentNode.getData();
            if(toCheck.getSampleID().equals(sampleID)){
                if(currentNode == head){
                    head = currentNode.getNextNode();
                    toRemove = currentNode;
                } else{ 
                    toRemove = currentNode;
                    previousNode.setNextNode(currentNode.getNextNode());
                    currentNode.setNextNode(null);
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return toRemove;
    }

    public Node getHeadNode(){
        return head;
    }

}
