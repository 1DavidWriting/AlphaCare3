
package alphacare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Caregiver extends User implements java.io.Serializable {

    private int caregiverID;
    private PatientList patientList;
    private EHR healthRecord;    
    
    
    /**
     * This is the default constructor for the Caregiver class.
     */
    public Caregiver(int ID, String fullName, String userName, String pass) {
        
        super(ID, fullName, userName, pass, "Caregiver");
        
    }

    /**
     * Returns the care giver id for the care giver;
     * @return the caregiverID
     */
    public int getCaregiverID() {
        return this.caregiverID;
    }

    /**
     * Sets the care giver id for the care giver;
     * @param caregiverID the caregiverID to set
     */
    public void setCaregiverID(int caregiverID) {
        this.caregiverID = caregiverID;
        
    }
    
    /**
     * Returns the patient list for the care giver.
     * @return the patientList
     */
    public PatientList getPatientList() {
        return patientList;
        
    }
    
    public void saveCaregiver(){
        String filename = (this.getUserName() + ".ser");
        // Serialization 
		try
		{ 
			//Saving of object in a file 
			FileOutputStream file = new FileOutputStream(filename);                        
			ObjectOutputStream out = new ObjectOutputStream(file);
                        out.writeObject(this);
                        out.close();
			file.close(); 
			//System.out.println(this.getFullName() + " has been serialized"); 

		} 
		
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		}
    }

    /**
     * Sets the patient list for the care giver.
     * @param patientList the patientList to set
     */
    public void setPatientList(PatientList patientList) {
        this.patientList = patientList;
    }

    /**
     * @return the caregiverUsername
     */

    
    
    public EHR getHealthRecord() {
        return healthRecord;
    }

    public void setHealthRecord(EHR healthRecord) {
        this.healthRecord = healthRecord;
    }
    
}
