
package alphacare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Period;
import java.time.LocalDate;

public class Patient extends User implements java.io.Serializable{
    
    
    private LocalDate birthDate;
    private String primCareDoc;
    private EHR healthRecord;
    
    
    /*     
      User: int ID, , String fullName, String userName, String pass, String userType
      Patient: all of above plus birthday
     */
    
    public Patient (int ID, String fullName, String userName, String pass, LocalDate birthday) {         
         super(ID, fullName, userName, pass, "Patient");
         birthDate = birthday;         
    }
   
    /*     
      User: int ID, String name, String pass, String userType
      Patient: all of above plus birthday primary care doc and EHR
     */
    public Patient (int ID, String fullName, String userName, String pass, LocalDate birthday, String primaryCareDoc, EHR ehr) {
         
         super(ID, fullName, userName, pass, "Patient");
         birthDate = birthday;
         primCareDoc = primaryCareDoc;
         healthRecord = ehr;
    }
    
    public void savePatient(){
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
     * Returns the birth date for the patient.
     * @return the birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date for the patient.
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Returns the primary care doctor for the patient.
     * @return the primCareDoc
     */
    public String getPrimCareDoc() {
        return primCareDoc;
    }

    /**
     * Sets the primary care doctor for the patient.
     * @param primCareDoc the primCareDoc to set
     */
    public void setPrimCareDoc(String primCareDoc) {
        this.primCareDoc = primCareDoc;
    }

    /**
     * Returns the electronic health record for the patient.
     * @return the healthRecord
     */
    public EHR getHealthRecord() {
        return healthRecord;
    }

    /**
     * Sets the electronic health record for the patient.
     * @param healthRecord the healthRecord to set
     */
    public void setHealthRecord(EHR healthRecord) {
        this.healthRecord = healthRecord;
    }
    
    public int getCurrentAge(){
        LocalDate today;
        today = LocalDate.now();
        int age;
        age = Period.between(this.birthDate, today).getYears();        
        return age;
    }
    
    //calculate age of patient and set the permissions of canUpdateData to false
    public void checkIsMinor(){
         int age = getCurrentAge();
         if (age < 18) {
            this.getPermissions().canUpdateData = false;
         }
    }

}
