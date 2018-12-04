/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author David
 */
public class DataCreation {
    private Patient patient1;
    private Patient patient2;
    private Physician physician1;
    private Caregiver caregiver1;
    private PatientList patientList1;
    private Administrator admin1;
    
    public DataCreation(){
        patient1 = getPatientFromFile("js1");
        patient2 = getPatientFromFile("ag2");
        
        if (patient1 == null){            
            System.out.println("No patient file found.  Creating patient 1 now...");
            createPatient();
        }

        if (patient2 == null){            
            System.out.println("No patient file found.  Creating patient 2 now...");
            createPatient2();
        }             
        createPatientList();
        createAdmin();        
        createPhysician();           
        createCaregiver();
        
    }
    
    private void createPatient2(){
        
        LocalDate happyBirthday = LocalDate.of(1987, 10, 24);
        EHR ehr1 = createEHR();
        setPatient2(new Patient(2, "Andrew Gordan", "ag2", "easy2", happyBirthday, "Doctor DoMore", ehr1));
        getPatient2().setHealthRecord(ehr1);
        
    } 
    
    private void createPatientList(){
        
        setPatientList1(new PatientList());
        patient1.savePatient();
        patient2.savePatient();
        getPatientList1().addPatient(getPatient1());
        getPatientList1().addPatient(getPatient2());
        System.out.println("Patient list has " + getPatientList1().getPatientObjectList().size() + " patients");
        for (int i = 0; i < getPatientList1().getPatientObjectList().size(); i++){
            System.out.println("Name: " + getPatientList1().getPatientObjectList().get(i).getFullName());
            System.out.println("User name: " + getPatientList1().getPatientObjectList().get(i).getUserName());
            System.out.println("Password: " + getPatientList1().getPatientObjectList().get(i).getPassword());
            System.out.println();        
        }
    
    }
    
    public void createAdmin() {
        
        this.setAdmin1(new Administrator(1, "Michael Jordan", "mjordan", "mj1"));
        admin1.setPatientList(patientList1);            
    }
    
    public void createPhysician(){
        
        this.setPhysician1(new Physician(1, "Ben Carson", "bcarson", "hud1"));
        physician1.setPatientList(patientList1);
        
    }
    
    public void createCaregiver(){
        
        this.setCaregiver1(new Caregiver(1,"Robin Williams", "dfire", "rwilliams1"));
        caregiver1.setPatientList(patientList1);
        
    }
     
    public void createPatient(){
        
        LocalDate happyBirthday = LocalDate.of(1995, 3, 12);
        EHR ehr1 = createEHR();
        setPatient1(new Patient(1, "Joe Snow", "js1", "easy1", happyBirthday, "Doctor DoMore", ehr1));
        getPatient1().setHealthRecord(ehr1);
        
    }
    
    public SOAP createSoap(){
        
        SOAP soap1 = new SOAP();
        soap1.setDate(new Date());
        soap1.setPhysicianName("Dr. Fillmore");
        soap1.setSubject("Patient feels fine but eyes are weak.");
        soap1.setObjective("Vision is poor.");
        soap1.setPlan("It's time to get a pair of spectacles.");
        soap1.setAssessment("Patient has myopia.");
        return soap1;
        
    }
    
    public Vitals createVitals(){
        
        int vitID = 5;
        int PatientID = 55;
        String BP = "130 / 85";
        int weight = 150;
        int sugar = 95;
        Vitals vitals = new Vitals(vitID, PatientID, BP, weight, sugar);
        return vitals;
        
    }
    
    public EHR createEHR(){
        
        EHR ehr1 = new EHR();
        ehr1.setPrescriptions("Prescriptions: \n\n *Albuterol \n\n *Depakote \n\n *Synthroid \n\n *Crestor");
        ehr1.setDiagnoses("Diagnoses: \n \n Asthma \n \n Diabetes \n \n Restless Leg Syndrome \n \n Hypertension");
        SOAP soap1 = createSoap();
        ehr1.setSoaps(soap1);
        //ehr1.setExercise("10 minutes of running today.");
        Vitals vitals1 = createVitals();
        ehr1.setVitals(vitals1);
        return ehr1;
        
    }

    /**
     * @return the patient1
     */
    public Patient getPatient1() {
        
        return patient1;
        
    }

    /**
     * @param patient1 the patient1 to set
     */
    public void setPatient1(Patient patient1) {
        
        this.patient1 = patient1;
        
    }
    
    private Patient getPatientFromFile(String userName){ 
        
                String filename = (userName + ".ser");
		Patient patientFromFile = null;
		// Deserialization 
		try
		{ 
			// Reading the object from a file 
			FileInputStream file = new FileInputStream(filename); 
			ObjectInputStream in = new ObjectInputStream(file); 
			
			// Method for deserialization of object 
			patientFromFile = (Patient)in.readObject(); 
			
			in.close(); 
			file.close(); 
			
		} 
		
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 
		
		catch(ClassNotFoundException ex) 
		{ 
			System.out.println("ClassNotFoundException is caught"); 
		}
                return patientFromFile;
        }

    /**
     * @return the physician1
     */
    public Physician getPhysician1() {
        return physician1;
    }

    /**
     * @param physician1 the physician1 to set
     */
    public void setPhysician1(Physician physician1) {
        this.physician1 = physician1;
    }

    /**
     * @return the caregiver1
     */
    public Caregiver getCaregiver() {
        return getCaregiver1();
    }

    /**
     * @param caregiver the caregiver1 to set
     */
    public void setCaregiver(Caregiver caregiver) {
        this.setCaregiver1(caregiver);
    }

    /**
     * @return the patient2
     */
    public Patient getPatient2() {
        return patient2;
    }

    /**
     * @param patient2 the patient2 to set
     */
    public void setPatient2(Patient patient2) {
        this.patient2 = patient2;
    }

    /**
     * @return the caregiver1
     */
    public Caregiver getCaregiver1() {
        return caregiver1;
    }

    /**
     * @param caregiver1 the caregiver1 to set
     */
    public void setCaregiver1(Caregiver caregiver1) {
        this.caregiver1 = caregiver1;
    }

    /**
     * @return the patientList1
     */
    public PatientList getPatientList1() {
        return patientList1;
    }

    /**
     * @param patientList1 the patientList1 to set
     */
    public void setPatientList1(PatientList patientList1) {
        this.patientList1 = patientList1;
    }

    public Administrator getAdmin1() {
        return admin1;
    }

    public void setAdmin1(Administrator admin1) {
        this.admin1 = admin1;
    }
    
    
}
