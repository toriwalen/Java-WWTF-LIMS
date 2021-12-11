import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class creates batches of samples.
 *
 * @author Tori
 * @version 20211209
 */
public class SampleBatch
{
    protected ArrayList<Sample> batchList= new ArrayList<Sample>();
    protected int dateCreated;
    
    public SampleBatch(){
        batchList = new ArrayList<Sample>();
        dateCreated = 20211209;
    }
    public SampleBatch(String configFileIn) throws FileNotFoundException {
        File configFile = new File(configFileIn);
        try{
            Scanner sc = new Scanner(configFile);
            String firstLine = sc.nextLine();
            while(sc.hasNext()){
                String samplingLocation = sc.next();
                int sampleNumber = Integer.parseInt(sc.next());
                String sampleType = sc.next();
                String analysisRequired = sc.nextLine();
                Sample newSample = new Sample(20211210, samplingLocation, sampleNumber, sampleType, analysisRequired);
                addToBatch(newSample);
                newSample.viewAnalysisList();
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
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
    public static void main(String[] args){
        
        try{
        SampleBatch todaysSamples = new SampleBatch("config.txt");
        //todaysSamples.print();
        TSSBatch todaysTSSBatch = new TSSBatch(todaysSamples);
        //todaysTSSBatch.startAnalysisBatch();
        //todaysTSSBatch.completeAnalysisBatch();
        //todaysTSSBatch.printBatchResults();
        todaysTSSBatch.print();
    }
    catch (FileNotFoundException e){
            e.printStackTrace();
        }
    
            }
}
