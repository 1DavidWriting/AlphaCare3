
package alphacare;

import java.util.ArrayList;


public class Vitals implements java.io.Serializable{
    
    private int vitalsID;
    private int patientID;
    private String bloodPressure;
    private int weight;
    private int bloodSugar;
    
    
    /**
     * This is the default constructor for the Vitals class.
     */
    public Vitals(int newVitalsID, int newPatientID, String newBloodPressure, int newWeight, int newBloodSugar) {
        vitalsID = newVitalsID;
        patientID = newPatientID;
        bloodPressure = newBloodPressure;
        weight = newWeight;
        bloodSugar = newBloodSugar;
        
    }
    
    /**
     * It combines all vitals.
     * @return 
     */
    public ArrayList GetAllVitals() {        
        ArrayList vitalStats = new ArrayList<>();        
        vitalStats.add(bloodPressure);
        vitalStats.add(weight);
        vitalStats.add(bloodSugar);
        return vitalStats;
    }

    /**
     * Returns the vitals id for the vitals.
     * @return the vitalsID
     */
    public int getVitalsID() {
        return vitalsID;
    }

    /**
     * Sets the vitals id for the vitals.
     * @param vitalsID the vitalsID to set
     */
    public void setVitalsID(int vitalsID) {
        this.vitalsID = vitalsID;
    }

    /**
     * Returns the patient id for the vitals.
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * Sets the patient id for the vitals.
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * Returns the blood pressure for the vitals.
     * @return the bloodPressure
     */
    public String getBloodPressure() {
        return bloodPressure;
    }

    /**
     * Sets the blood pressure for the vitals.
     * @param bloodPressure the bloodPressure to set
     */
    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    /**
     * Returns the weight for the vitals.
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight for the vitals.
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns the blood sugar for the vitals.
     * @return the bloodSugar
     */
    public int getBloodSugar() {
        return bloodSugar;
    }

    /**
     * Returns the blood sugar for the vitals.
     * @param bloodSugar the bloodSugar to set
     */
    public void setBloodSugar(int bloodSugar) {
        this.bloodSugar = bloodSugar;
    }
    
    public String outputAllVitals(){
        String output = (
        "Vitals ID: " + this.vitalsID + ", " +
        "Patient ID: " + this.patientID + ", " +
        "Blood Pressure: " + this.bloodPressure + ", " +
        "Weight: " + this.weight + ", " +
        "Blood Sugar: " + this.bloodSugar      
        );
        return output;
    }
    
}
