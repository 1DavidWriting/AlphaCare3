
package alphacare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Administrator extends User implements java.io.Serializable {
    
    private int adminID;
    private PatientList patientList;
    
    /**
     * This is the default constructor for the Administrator class.
     */
    public Administrator(int ID, String fullName, String userName, String pass) {
        
       super(ID, fullName, userName, pass, "Administrator");
       
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    /**
     * Returns the patient list for the care giver.
     * @return the patientList
     */
    public PatientList getPatientList() {
        return patientList;
        
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

    public void saveAdmin(){
        
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
    
    
}
