
package alphacare;

import java.util.Date;


public class SOAP implements java.io.Serializable {
    
    private int patientID;
    private String physicianName;
    private Date date;
    private String subject;
    private String objective;
    private String assessment;
    private String plan;
    
    /**
     * This is the default constructor for the SOAP class.
     */
    public SOAP() {
        
        
    }
    
    public String getSOAPtext(){
        String soapText = "MEDICAL NOTES: \n\n";
        soapText = soapText.concat("Physician: " + physicianName + "\n");
        soapText = soapText.concat("Examination On: " + date + "\n\n");
        soapText = soapText.concat("Subjective: " + subject + "\n\n");
        soapText = soapText.concat("Objective: " + objective + "\n\n");
        soapText = soapText.concat("Assesment: " + assessment + "\n\n");
        soapText = soapText.concat("Plan: " + plan);
        //System.out.println(soapText);
        return soapText;
    }

    /**
     * Returns the patient id for the SOAP;
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * Sets the patient id for the SOAP;
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    

    /**
     * Returns the date for the SOAP;
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date for the SOAP;
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the subject for the SOAP;
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject for the SOAP;
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Returns the objective for the SOAP;
     * @return the objective
     */
    public String getObjective() {
        return objective;
    }

    /**
     * Sets the objective for the SOAP;
     * @param objective the objective to set
     */
    public void setObjective(String objective) {
        this.objective = objective;
    }

    /**
     * Returns the assessment for the SOAP;
     * @return the assessment
     */
    public String getAssessment() {
        return assessment;
    }

    /**
     * Sets the assessment for the SOAP;
     * @param assessment the assessment to set
     */
    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    /**
     * @return the plan
     */
    public String getPlan() {
        return plan;
    }

    /**
     * @param plan the plan to set
     */
    public void setPlan(String plan) {
        this.plan = plan;
    }

    /**
     * @return the physicianName
     */
    public String getPhysicianName() {
        return physicianName;
    }

    /**
     * @param physicianName the physicianName to set
     */
    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }
    
}
