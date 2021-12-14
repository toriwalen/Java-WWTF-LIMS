import java.util.ArrayList;
/**
 * A sample batch is considered to be all samples taken during one sampling "event" - a period of time where samples are 
 * taken in quick succession from multiple locations around the plant. 
 *
 * @author Tori
 * @version 20211209.1
 */
public class SampleBatch
{
    protected ArrayList<Sample> batchList= new ArrayList<Sample>();
    protected int dateCreated;
    
    /**
     * Default constructor. Date is a placeholder for now.
     */
    public SampleBatch(){
        batchList = new ArrayList<Sample>();
        dateCreated = 20211209;
    }
    
    /**
     * Create a constructor for a config file. While the file has next line, create new samples from the info in the file.
     */
    public SampleBatch(String fileIn){
        
    }
    
    /**
     * Prints samples in 
     */
    public ArrayList<Sample> print(){
        System.out.println("Samples in batch from " + dateCreated);
        for(Sample sample : batchList){
            System.out.println(sample.toString());
        }
        return batchList;
    }
    
    public ArrayList<Sample> getBatchList(){
        return batchList;
    }

    /**
     * Change to private later.
     */
    public void add(Sample sampleIn){
        boolean addToBatch = true;
        for(Sample sample : batchList){
            if(sample.equals(sampleIn)){
                addToBatch = false;
            }
        }
        if(addToBatch == true){
            batchList.add(sampleIn);
        }
    }
    
}
