
package alphacare;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;


public class PatientController implements ActionListener {
    private int patientID;
    private Boolean access = false;
    private PatientView patientView;
    Patient patient;
    private String resetText;
    String currentSelection;
    private LoginView loginView;

    
    public PatientController(Patient thePatient, LoginView theLogin){        
        patient = thePatient;        
        createPatientView();
        loginView = theLogin;
    }
   
    
    public void createPatientView(){
        patientView = new PatientView(patient);
        addActionListenersforSelectionPanelButtons();
        addActionListenersForSaveCancelButtons();
        addActionListenerForLogOutButton();
    }
        
    private void addActionListenerForLogOutButton(){
        patientView.getFrame().getPanel().getLogOutButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object obj = ae.getSource();
                if (obj == patientView.getFrame().getPanel().getLogOutButton()){
                    System.out.println("Logging out...");
                    patientView.getFrame().setVisible(false);
                    loginView.clearFields();
                    loginView.getFrame().setVisible(true);
                }
            }
        });
    }
    
    private void addActionListenersforSelectionPanelButtons(){
            //the start button is currently set to disabled and invisible.  We may not need it.
            patientView.getFrame().getPanel().getStartButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getStartButton()){
                         //System.out.println("Start button clicked");
                         patientView.getFrame().getPanel().getNameLabel().setText("Welcome, " + patient.getFullName());
                         patientView.getFrame().getPanel().getSelectionPanel().setVisible(true);
                         patientView.getFrame().getPanel().getStartButton().setVisible(false);
                         patientView.getFrame().getPanel().getPatientInfoTextArea().setVisible(true);
                    }
                };
            });           
           
            //exercise
            patientView.getFrame().getPanel().getExerciseButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getExerciseButton()){
                        patientView.getFrame().getPanel().getCategoryLabel().setText("Exercise Info: ");
                         patientView.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getExercise());
                         resetText = patientView.getFrame().getPanel().getPatientInfoTextArea().getText();
                         currentSelection = "exercise";
                         showEditSaveControlButtons();
                    }
                };
            });
            //medical record SOAP
            patientView.getFrame().getPanel().getSoapButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getSoapButton()){
                        patientView.getFrame().getPanel().getCategoryLabel().setText("Medical Record: ");                          
                          patientView.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getSoaps().getSOAPtext());
                          //Patients can't edit medical records
                          hideEditSaveControlButtons();
                    }
                };
            });
            //blood sugar
            patientView.getFrame().getPanel().getBloodSugarButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getBloodSugarButton()){
                        patientView.getFrame().getPanel().getCategoryLabel().setText("Blood Sugar: ");
                        patientView.getFrame().getPanel().getPatientInfoTextArea().setText(Integer.toString(patient.getHealthRecord().getVitals().getBloodSugar()));
                        resetText = patientView.getFrame().getPanel().getPatientInfoTextArea().getText();
                        currentSelection = "blood sugar";
                        showEditSaveControlButtons();
                    }
                };
            });
            //prescriptions
            patientView.getFrame().getPanel().getPrescriptionsButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getPrescriptionsButton()){
                        patientView.getFrame().getPanel().getCategoryLabel().setText("Prescriptions: ");
                        String prescriptions = patient.getHealthRecord().getPrescriptions();
                        patientView.getFrame().getPanel().getPatientInfoTextArea().setText(prescriptions);
                        //Patients can't edit prescriptions
                        hideEditSaveControlButtons();
                    }
                };
            });
            //weight
            patientView.getFrame().getPanel().getWeightButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getWeightButton()){
                        patientView.getFrame().getPanel().getCategoryLabel().setText("Weight: ");
                         patientView.getFrame().getPanel().getPatientInfoTextArea().setText(Integer.toString(patient.getHealthRecord().getVitals().getWeight()));
                         resetText = patientView.getFrame().getPanel().getPatientInfoTextArea().getText();
                         currentSelection = "weight";
                         showEditSaveControlButtons();
                    }
                };
            });
            //diagnoses
            patientView.getFrame().getPanel().getDiagnosesButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getDiagnosesButton()){
                        patientView.getFrame().getPanel().getCategoryLabel().setText("Diagnoses: ");
                         patientView.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getDiagnoses());
                         //Patients can't edit diagnoses
                         hideEditSaveControlButtons();
                    }
                };
            });
            //blood pressure
            patientView.getFrame().getPanel().getBloodPressureButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getBloodPressureButton()){
                        patientView.getFrame().getPanel().getCategoryLabel().setText("Blood Pressure: ");
                         patientView.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getVitals().getBloodPressure());
                         resetText = patientView.getFrame().getPanel().getPatientInfoTextArea().getText();
                         currentSelection = "blood pressure";
                         showEditSaveControlButtons();
                    }
                };
            });
            
            
            
        }
     
     private void addActionListenerForPatientTextArea(){
         patientView.getFrame().getPanel().getPatientInfoTextArea().addPropertyChangeListener(new PropertyChangeListener(){
             @Override
             public void propertyChange(PropertyChangeEvent pce) {
                 Object change = pce.getSource();
                 if (change ==  patientView.getFrame().getPanel().getPatientInfoTextArea()){
                     System.out.println("Editing PatientInfoTextArea");
                     patientView.getFrame().getPanel().getCancelButton().setEnabled(true);
                     patientView.getFrame().getPanel().getSaveButton().setEnabled(true);
                 }
             }
         });
     }
    
     private void addActionListenersForSaveCancelButtons(){        
        //cancel button 
         patientView.getFrame().getPanel().getCancelButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getCancelButton()){                        
                        patientView.getFrame().getPanel().getPatientInfoTextArea().setText(resetText);                        
                    }                    
                }            
            });
         //save button
         patientView.getFrame().getPanel().getSaveButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    Object obj = ae.getSource();
                    if (obj == patientView.getFrame().getPanel().getSaveButton()){
                        String textToSave = patientView.getFrame().getPanel().getPatientInfoTextArea().getText();
                        System.out.println("Saving " + currentSelection + " as " + textToSave);
                        switch(currentSelection){
                            case "exercise": patient.getHealthRecord().setExercise(textToSave);
                                break;
                            case "blood sugar": int bloodSugar = Integer.parseInt(textToSave);
                                patient.getHealthRecord().getVitals().setBloodSugar(bloodSugar);
                                break;
                            case "weight": int weight = Integer.parseInt(textToSave);
                                patient.getHealthRecord().getVitals().setWeight(weight);
                                break;
                            case "blood pressure": patient.getHealthRecord().getVitals().setBloodPressure(textToSave);
                                break;
                            default: System.out.println("Error: text not be saved");
                                break;
                        }
                        patient.savePatient();                        
                    }                    
                }            
            });
         
         
     }   
        
     private void showEditSaveControlButtons(){
         patient.checkIsMinor();
         if (patient.getPermissions().canUpdateData){
            patientView.getFrame().getPanel().getSaveButton().setVisible(true);
            patientView.getFrame().getPanel().getCancelButton().setVisible(true);
            patientView.getFrame().getPanel().getEditButton().setVisible(false);
            patientView.getFrame().getPanel().getPatientInfoTextArea().setEditable(true);
            patientView.getFrame().getPanel().getSaveButton().setEnabled(false);
            patientView.getFrame().getPanel().getCancelButton().setEnabled(false);
            patientView.getFrame().getPanel().getEditButton().setVisible(false);
            patientView.getFrame().getPanel().getEditButton().setEnabled(false);
         }
     }
     
     private void hideEditSaveControlButtons(){
         patient.checkIsMinor();
         if (patient.getPermissions().canUpdateData){
            patientView.getFrame().getPanel().getSaveButton().setVisible(false);
            patientView.getFrame().getPanel().getCancelButton().setVisible(false);
            patientView.getFrame().getPanel().getEditButton().setVisible(false);
            patientView.getFrame().getPanel().getEditButton().setEnabled(false);
            patientView.getFrame().getPanel().getPatientInfoTextArea().setEditable(false);
            patientView.getFrame().getPanel().getSaveButton().setEnabled(false);
            patientView.getFrame().getPanel().getCancelButton().setEnabled(false);
         }
     }
        
    //action performed necessary for implementing action listener interface
    @Override
    public void actionPerformed(ActionEvent event) 
    {       	
    }
   
    /**
     * @return the patientID
     */
    public int getPatientID() {
        return this.patientID; 
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    
    
    
    
    
    
    
}
