
package alphacare;


public class EHR implements java.io.Serializable {
    
    private int ehrID;
    private String diagnoses;
    private Vitals vitals;
    private String images;
    private String prescriptions;
    private String test;
    private SOAP soaps;
    private String alerts;
    private String exercise;
    
    /**
     * This is the default constructor for the EHR class.
     */
    public EHR() {
        
        
    }
    
   

    /**
     * @return the ehrID
     */
    public int getEhrID() {
        return ehrID;
    }

    /**
     * @param ehrID the ehrID to set
     */
    public void setEhrID(int ehrID) {
        this.ehrID = ehrID;
    }

    /**
     * @return the diagnoses
     */
    public String getDiagnoses() {
        return diagnoses;
    }

    /**
     * @param diagnoses the diagnoses to set
     */
    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    /**
     * @return the vitals
     */
    public Vitals getVitals() {
        return vitals;
    }

    /**
     * @param vitals the vitals to set
     */
    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }

    /**
     * @return the images
     */
    public String getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * @return the prescriptions
     */
    public String getPrescriptions() {
        return prescriptions;
    }

    /**
     * @param prescriptions the prescriptions to set
     */
    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }

    /**
     * @return the soaps
     */
    public SOAP getSoaps() {
        return soaps;
    }

    /**
     * @param soaps the soaps to set
     */
    public void setSoaps(SOAP soaps) {
        this.soaps = soaps;
    }

    /**
     * @return the alerts
     */
    public String getAlerts() {
        return alerts;
    }

    /**
     * @param alerts the alerts to set
     */
    public void setAlerts(String alerts) {
        this.alerts = alerts;
    }

    /**
     * @return the exercise
     */
    public String getExercise() {
        return exercise;
    }

    /**
     * @param exercise the exercise to set
     */
    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
    
    
    
    
}
