import java.util.ArrayList;
/**
 * This class creates batches of samples.
 *
 * @author Tori
 * @version 20211209.1
 */
public class SampleBatch
{
    protected ArrayList<Sample> batchList= new ArrayList<Sample>();
    protected int dateCreated;
    
    public SampleBatch(){
        batchList = new ArrayList<Sample>();
        dateCreated = 20211209;
    }

    public void print(){
        System.out.println("Samples in batch from " + dateCreated);
        for(Sample sample : batchList){
            System.out.println(sample.toString());
        }
    }
    public ArrayList<Sample> getBatchList(){
        return batchList;
    }

    /**
     * Change to private later.
     */
    public void addToBatch(Sample sampleIn){
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
