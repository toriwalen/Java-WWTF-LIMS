import java.util.ArrayList;

/**
 * This class creates objects reflecting real life samples taken from a
 * wastewater treatment plant.
 *
 * @author Tori
 * @version 20211209.1
 */
public class Sample
{
    // instance variables
    private String sampleID;//sampleID contains the date and sample location in a string
    private int sampleNumber;
    private int date; //date stores the sampling date as an ISO formatted date
    private String location; //locations are specified around the plant
    private String name; //effluent, influent, mlss
    private String type; //grab or composite
    private boolean needsBODAnalysis;
    private boolean needsFecalColiformAnalysis;
    private boolean needspHAnalysis;
    private boolean needsTSSAnalysis;
    private boolean complianceSample;
    private ArrayList<String> sampleLog = new ArrayList<String>();
    private ArrayList<Analysis> analysisList = new ArrayList<Analysis>();
    private Analysis BOD;
    private TSSAnalysis TSS;
    private Analysis pH;
    private Analysis fecalColiform;
    

    /**
     * Constructor for a sample being created using a string of required analysiss.
     * 
     */ 
    public Sample(int samplingDate, int sampleNumber, String samplingLocation, String sampleType, String analysisRequired){
        this.date = samplingDate;
        this.sampleNumber = sampleNumber;
        this.location = samplingLocation;
        this.assignSampleID();
        this.type = sampleType;
        this.addToSampleLog(type + " sample from " + location + " created");
        analysisRequired = analysisRequired.toLowerCase();
        if (analysisRequired.contains("bod") || analysisRequired.contains("biochemical oxygen demand")){
            this.needsBODAnalysis = true;
            BOD = new Analysis(this, "Bological Oxygen Demand");
            analysisList.add(BOD);
        }
        if (analysisRequired.contains("fecal coliforms") || analysisRequired.contains("fecal")){
            this.needsFecalColiformAnalysis = true;
            fecalColiform = new Analysis(this, "Fecal Coliforms");
            analysisList.add(fecalColiform);
        }
        if (analysisRequired.contains("ph")){
            this.needspHAnalysis = true;
            pH = new Analysis(this, "pH");
            analysisList.add(pH);
        }
        if (analysisRequired.contains("tss") || analysisRequired.contains("total suspended solids")){
            this.needsTSSAnalysis = true;
            TSS = new TSSAnalysis(this);
            analysisList.add(TSS);
        }
    }

    /**
     * This method prints the sample log.
     */
    public void viewSampleLog(){
        System.out.println("Sample log for sample " + sampleID);
        for(String entry : sampleLog){
            System.out.println(entry);
        }

    }

    /**
     * @param  none
     * @return    arrayList of strings - the sample log
     */
    public ArrayList<String> getSampleLog()
    {
        return this.sampleLog;
    }

    /**
     * @param - string to add to the sample log.
     * @ return none
     */
    public void addToSampleLog(String entry){
        String dateStamp = "DATESTAMP";
        this.sampleLog.add(dateStamp + " " + entry);
    }

    private void assignSampleID(){
        sampleID = date + location + "-" + sampleNumber;
    }

    public String getSampleID(){
        return sampleID;
    }

    public boolean needsBODAnalysis(){
        return needsBODAnalysis;
    }

    public boolean needsTSSAnalysis(){
        return needsTSSAnalysis;
    }

    public boolean needspHAnalysis(){
        return needspHAnalysis;
    }

    public boolean needsFecalColiformAnalysis(){
        return needsFecalColiformAnalysis;
    }
    public String getLocation(){
        return location;
    }
    public int getSampleNumber(){
        return sampleNumber;
    }
    private void addAnalysis(String analysisRequested){
        analysisRequested = analysisRequested.toLowerCase();
        boolean alreadyHasAnalysis = false;
        for(Analysis analysis: analysisList){
            if(analysisRequested.equals(analysis.getName().toLowerCase())){
                System.out.println("Sample is already assigned analysis");  
                alreadyHasAnalysis = true;
            }

        }
        if(alreadyHasAnalysis == false){

            if (analysisRequested.contains("bod") || analysisRequested.contains("biochemical oxygen demand")){
                if(BOD == null){
                    this.needsBODAnalysis = true;
                    BOD = new Analysis(this, "Biochemical Oxygen Demand");
                    analysisList.add(BOD);
                    System.out.println("Test sucessfully added");
                }
            } else if(analysisRequested.contains("fecal coliforms") || analysisRequested.contains("fecal")){
                if(fecalColiform == null){
                    this.needsFecalColiformAnalysis = true;
                    fecalColiform = new Analysis(this, "Fecal Coliforms");
                    analysisList.add(fecalColiform);
                    System.out.println("Test sucessfully added");
                } else if (analysisRequested.contains("ph")){
                    if(pH == null){
                        this.needspHAnalysis = true;
                        pH = new Analysis(this, "pH");
                        analysisList.add(pH);
                        System.out.println("Test sucessfully added");
                    }
                } else if(analysisRequested.contains("tss") || analysisRequested.contains("total suspended solids")){
                    if(TSS == null){
                        this.needsTSSAnalysis = true;
                        TSS = new TSSAnalysis(this);
                        analysisList.add(TSS);
                        System.out.println("Test sucessfully added");
                    } else {
                        System.out.println("Unknown analysis requested");
                    }

                }
            }
        }  
    }

    public void viewAssignedAnalysis(){
        System.out.println("Tests assigned to sample " + sampleID);
        for(Analysis analysis : analysisList){
            System.out.println(analysis);
        }
    }

    /*
     * TO DO:
     * removeTest(String analysisName)
     * removes analysis from arraylist. can we destroy the analysis???
     * 
     */

    public TSSAnalysis getTSSAnalysis(){
        return TSS;
    }

    public Analysis getBODAnalysis(){
        return BOD;
    }

    public Analysis getpHAnalysis(){
        return pH;
    }

    public Analysis getFecalColiformAnalysis(){
        return fecalColiform;
    }

    public boolean hasTSSAnalysis(){
        if(TSS != null){
            for(Analysis analysis: this.analysisList){
                if (analysis.getName().equals("TSS")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasBODAnalysis(){
        if(TSS != null){
            for(Analysis analysis: this.analysisList){
                if (analysis.getName().equals("BOD")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean haspHAnalysis(){
        if(TSS != null){
            for(Analysis analysis: this.analysisList){
                if (analysis.getName().equals("pH")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasFecalColiformAnalysis(){
        if(TSS != null){
            for(Analysis analysis: this.analysisList){
                if (analysis.getName().equals("Fecal coliform")){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean equals(Sample other){
        if(this.getSampleID().equals(other.getSampleID())){
            return true;
        }
        return false;
    }
    public String toString(){
        return sampleID;
    }
    public void print(){
        System.out.println("Sample " + sampleID + " from " + location);
    }
    public void viewAnalysisList(){
        System.out.println("Tests queued for sample: " + sampleID);
        for(Analysis analysis : analysisList){
            System.out.println(analysis.getName());
        }
    }
        }