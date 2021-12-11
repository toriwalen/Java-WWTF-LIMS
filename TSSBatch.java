import java.util.ArrayList;
/**
 * This class creates batches of Analysis objects.
 *
 * @author Tori
 * @version 20211210.1
 */
public class TSSBatch
{
    protected ArrayList<TSSAnalysis> batchList= new ArrayList<TSSAnalysis>();
    protected int dateCreated;
    Sample blank = new Sample(20211210, 1, "blank", "blank", "Total Suspended Solids");
    Sample control = new Sample(20211210, 1, "control", "control", "Total Suspended Solids");
    //int samplingDate, int sampleNumber, String samplingLocation, String sampleType, String analysissRequired
    public TSSBatch(SampleBatch sampleBatch){
        batchList = new ArrayList<TSSAnalysis>();
        dateCreated = 20211209;
        addToBatch(blank.getTSSAnalysis());
        addToBatch(control.getTSSAnalysis());
        for(Sample sample: sampleBatch.getBatchList()){
            if(sample.needsTSSAnalysis()){
                addToBatch(sample.getTSSAnalysis());
            }
        }
    }
    public void startAnalysisBatch(){
      for(TSSAnalysis analysis : batchList){
          analysis.startAnalysis();
      }
    }
    public void completeAnalysisBatch(){
        for(TSSAnalysis analysis : batchList){
          analysis.completeAnalysis();
      }
    }
    public void printBatchResults(){
        for(TSSAnalysis analysis : batchList){
          System.out.println(analysis.getSample().getLocation()+ "-" + analysis.getSample().getSampleNumber() + " TSS result is " + analysis.getResult() + " mg/L");
      }
    }
    public void print(){
        System.out.println("Samples in Total Suspended Solids batch from " + dateCreated);
        for(TSSAnalysis analysis : batchList){
            System.out.println(analysis.getSample().getLocation() + "-" + analysis.getSample().getSampleNumber());
        }
    }
    public ArrayList<TSSAnalysis> getBatchList(){
        return batchList;
    }

    /**
     * Change to private later.
     */
    public void addToBatch(TSSAnalysis analysisIn){
        
            this.batchList.add(analysisIn);
        
    }
}
