import java.util.ArrayList;
/**
 * Write a description of interface Batch here.
 *
 * @author Tori Walen
 * @version 20211209
 */
public class Batch
{
    protected ArrayList<Object> batchList;
    protected int dateCreated;
    public Batch(){
        batchList = new ArrayList<Object>();
        dateCreated = 20211209;
    }

    public ArrayList<Object> getBatchList(){
        return batchList;
    }

    public void printBatchList(){
        System.out.println("Todays objects are:");
        for(Object item : batchList){
            System.out.println(item);
        }
    }

    public void addToBatch(Object objectIn){
        boolean addToBatch = true;
        for(Object item : batchList){
            if(item.equals(objectIn)){
                addToBatch = false;
            }
        }
        if(addToBatch == true){
            batchList.add(objectIn);
        }
    }

}
