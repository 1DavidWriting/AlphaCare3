package alphacare;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PatientList implements java.io.Serializable{
    
    private int listID;
    ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<Patient> patientObjectList = new ArrayList<>(); 
    
    /**
     * This is the default constructor for the PatientList class.
     */
    public PatientList() {
        
        
    }
    
    public void savePatientList(){
        String filename = ("patientList.ser");
        // Serialization 
		try
		{ 
			//Saving of object in a file 
			FileOutputStream file = new FileOutputStream(filename);                        
			ObjectOutputStream out = new ObjectOutputStream(file);
                        out.writeObject(this);
                        out.close();
			file.close(); 
			System.out.println("List has been serialized"); 

		} 
		
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		}
    }
    
    
    
    /**
     * It allows to get lists.
     * @return 
     */
    public ArrayList getList() {
        //return this.idList;
        //stub:
        ArrayList stubList = new ArrayList <>();
        stubList.add(1);
        stubList.add(2);
        return stubList;
    }
    
    
    
    /**
     * It allows to add a patient.
     * @param newID
     */
    public void addPatient(int newID) {
        this.idList.add(newID);
        //stub:
        ArrayList stubList = new ArrayList <>();
        stubList.add(1);
        stubList.add(2);
        stubList.add(newID);
        System.out.println("Added patientId to list:" + newID);
        System.out.println("Updated list:");
        System.out.println(stubList);   
    }

    /**
     * @return the listID
     */
    public int getListID() {
        return listID;        
    }

    /**
     * @param listID the listID to set
     */
    public void setListID(int listID) {
        this.listID = listID;
        System.out.println("List ID set to: " + listID);
    }

    /**
     * @return the patientObjectList
     */
    public ArrayList<Patient> getPatientObjectList() {
        return patientObjectList;
    }
    
    public void addPatient(Patient thePatient){
        this.patientObjectList.add(thePatient);
        System.out.println("Adding " + thePatient.getFullName());
    }

    /**
     * @param patientObjectList the patientObjectList to set
     */
    public void setPatientObjectList(ArrayList<Patient> patientObjectList) {
        this.patientObjectList = patientObjectList;
    }
    
}
