
package alphacare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Physician extends User implements java.io.Serializable{
    
    private int physicianID;
    private PatientList patientList;
    private EHR healthRecord;
    
    /**
     * This is the default constructor for the Physician class.
     */
    public Physician(int ID, String fullName, String userName, String pass) {
        
        super(ID, fullName, userName, pass, "Physician");
        
    }
    
    public void savePhysician(){
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
     * Returns the patient list for the physician.
     * @return the patientList
     */
    public PatientList getPatientList() {
        return patientList;
    }

    /**
     * Sets the patient list for the physician.
     * @param patientList the patientList to set
     */
    public void setPatientList(PatientList patientList) {
        this.patientList = patientList;
    }

    /**
     * @return the physicianID
     */
    public int getPhysicianID() {
        return physicianID;
    }

    /**
     * @param physicianID the physicianID to set
     */
    public void setPhysicianID(int physicianID) {
        this.physicianID = physicianID;
    }

    public EHR getHealthRecord() {
        return healthRecord;
    }

    public void setHealthRecord(EHR healthRecord) {
        this.healthRecord = healthRecord;
    }
    
}
