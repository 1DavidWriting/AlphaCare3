
package alphacare;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComboBox;

public class PhysicianController implements ActionListener {

    private int patientID;
    private Boolean access = false;
    private PhysicianView view;    
    private Physician physician;
    private String resetText;
    String currentSelection;
    private Patient patient;
    private LoginView loginView;
    
    
    public PhysicianController(Physician thePhysician, LoginView theLoginView){
        
        physician = thePhysician;
        loginView = theLoginView;
        createPhysicianView();
        patient = physician.getPatientList().getPatientObjectList().get(0);
        disableSelectionPanel();    
        
    }

    public void disableSelectionPanel(){
        
        view.getFrame().getPanel().getExerciseButton().setEnabled(false);
        view.getFrame().getPanel().getSoapButton().setEnabled(false);
        view.getFrame().getPanel().getBloodSugarButton().setEnabled(false);
        view.getFrame().getPanel().getPrescriptionsButton().setEnabled(false);
        view.getFrame().getPanel().getWeightButton().setEnabled(false);
        view.getFrame().getPanel().getDiagnosesButton().setEnabled(false);
        view.getFrame().getPanel().getBloodPressureButton().setEnabled(false);
        view.getFrame().getPanel().getOptionsLabel().setText("");
         
    }   
    
    public void enableSelectionPanel(){
        
        view.getFrame().getPanel().getExerciseButton().setEnabled(true);
        view.getFrame().getPanel().getSoapButton().setEnabled(true);
        view.getFrame().getPanel().getBloodSugarButton().setEnabled(true);
        view.getFrame().getPanel().getPrescriptionsButton().setEnabled(true);
         view.getFrame().getPanel().getWeightButton().setEnabled(true);
         view.getFrame().getPanel().getDiagnosesButton().setEnabled(true);
         view.getFrame().getPanel().getBloodPressureButton().setEnabled(true);
         //view.getFrame().getPanel().getOptionsLabel().setVisible(true);
         view.getFrame().getPanel().getOptionsLabel().setText("Choose One:");
         
    }    
    
    public void createPhysicianView(){
        
        view = new PhysicianView(physician);
        addActionListenersforSelectionPanelButtons();
        addActionListenersForSaveCancelButtons();
        addActionListenerForPatientSelectionMenu();
        addActionListenerForLogOutButton();       
        
    }    
    
    
    
    private void addActionListenerForPatientSelectionMenu(){
        
        this.view.getFrame().getPanel().getSelectionMenu().addActionListener(new ActionListener() { 
            
            @Override
            public void actionPerformed(ActionEvent event) {
                
                JComboBox<String> combo = (JComboBox<String>) event.getSource();                             
                int itemNum;
                itemNum = view.getFrame().getPanel().getSelectionMenu().getSelectedIndex();
                itemNum--;
                System.out.println("Selected list item number" + itemNum);
                
                if (itemNum > -1){
                    
                    patient = physician.getPatientList().getPatientObjectList().get(itemNum);
                    view.getFrame().getPanel().getPatientLabel().setText(patient.getFullName());
                    enableSelectionPanel();
                    
                }
                else{
                    
                    disableSelectionPanel();
                    view.getFrame().getPanel().getPatientLabel().setText("Please select a Patient");
                    
                }                
                
                view.getFrame().getPanel().getPatientInfoTextArea().setText("");
                view.getFrame().getPanel().getCategoryLabel().setText("");
                hideEditSaveControlButtons();
                
            }
            
        });
        
    }    
    
    private void addActionListenerForLogOutButton(){
        
        view.getFrame().getPanel().getLogOutButton().addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae){
                
                Object obj = ae.getSource();
                
                if (obj == view.getFrame().getPanel().getLogOutButton()){
                    
                    System.out.println("Logging out...");
                    view.getFrame().setVisible(false);
                    loginView.clearFields();
                    loginView.getFrame().setVisible(true);
                    
                }
                
            }
            
        });
        
    }
    
        private void addActionListenersforSelectionPanelButtons(){
            
            //exercise
            view.getFrame().getPanel().getExerciseButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getExerciseButton()){
                        view.getFrame().getPanel().getCategoryLabel().setText("Exercise Info");
                         view.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getExercise());
                         resetText = view.getFrame().getPanel().getPatientInfoTextArea().getText();
                         currentSelection = "exercise";
                         showEditSaveControlButtons();
                    }
                };
            });
            //medical record SOAP
            view.getFrame().getPanel().getSoapButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getSoapButton()){
                        view.getFrame().getPanel().getCategoryLabel().setText("Medical Record ");                          
                          view.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getSoaps().getSOAPtext());
                          //Patients can't edit medical records
                          hideEditSaveControlButtons();
                    }
                };
            });
            //blood sugar
            view.getFrame().getPanel().getBloodSugarButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getBloodSugarButton()){
                        view.getFrame().getPanel().getCategoryLabel().setText("Blood Sugar ");
                        view.getFrame().getPanel().getPatientInfoTextArea().setText(Integer.toString(patient.getHealthRecord().getVitals().getBloodSugar()));
                        resetText = view.getFrame().getPanel().getPatientInfoTextArea().getText();
                        currentSelection = "blood sugar";
                        showEditSaveControlButtons();
                    }
                };
            });
            //prescriptions
            view.getFrame().getPanel().getPrescriptionsButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getPrescriptionsButton()){
                        view.getFrame().getPanel().getCategoryLabel().setText("Prescriptions ");
                        String prescriptions = patient.getHealthRecord().getPrescriptions();
                        view.getFrame().getPanel().getPatientInfoTextArea().setText(prescriptions);
                        //Patients can't edit prescriptions
                        hideEditSaveControlButtons();
                    }
                };
            });
            //weight
            view.getFrame().getPanel().getWeightButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getWeightButton()){
                        view.getFrame().getPanel().getCategoryLabel().setText("Weight ");
                         view.getFrame().getPanel().getPatientInfoTextArea().setText(Integer.toString(patient.getHealthRecord().getVitals().getWeight()));
                         resetText = view.getFrame().getPanel().getPatientInfoTextArea().getText();
                         currentSelection = "weight";
                         showEditSaveControlButtons();
                    }
                };
            });
            //diagnoses
            view.getFrame().getPanel().getDiagnosesButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getDiagnosesButton()){
                        view.getFrame().getPanel().getCategoryLabel().setText("Diagnoses ");
                         view.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getDiagnoses());
                         //Patients can't edit diagnoses
                         hideEditSaveControlButtons();
                    }
                };
            });
            //blood pressure
            view.getFrame().getPanel().getBloodPressureButton().addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getBloodPressureButton()){
                        view.getFrame().getPanel().getCategoryLabel().setText("Blood Pressure ");
                         view.getFrame().getPanel().getPatientInfoTextArea().setText(patient.getHealthRecord().getVitals().getBloodPressure());
                         resetText = view.getFrame().getPanel().getPatientInfoTextArea().getText();
                         currentSelection = "blood pressure";
                         showEditSaveControlButtons();
                    }
                };
            });
            
            
            
        }
     
     private void addActionListenerForPatientTextArea(){
         view.getFrame().getPanel().getPatientInfoTextArea().addPropertyChangeListener(new PropertyChangeListener(){
             @Override
             public void propertyChange(PropertyChangeEvent pce) {
                 Object change = pce.getSource();
                 if (change ==  view.getFrame().getPanel().getPatientInfoTextArea()){
                     System.out.println("Editing PatientInfoTextArea");
                     view.getFrame().getPanel().getCancelButton().setEnabled(true);
                     view.getFrame().getPanel().getSaveButton().setEnabled(true);
                 }
             }
         });
     }
    
     private void addActionListenersForSaveCancelButtons(){        
        //cancel button 
         view.getFrame().getPanel().getCancelButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getCancelButton()){                        
                        view.getFrame().getPanel().getPatientInfoTextArea().setText(resetText);                        
                    }                    
                }            
            });
         //save button
         view.getFrame().getPanel().getSaveButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    Object obj = ae.getSource();
                    if (obj == view.getFrame().getPanel().getSaveButton()){
                        String textToSave = view.getFrame().getPanel().getPatientInfoTextArea().getText();
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
            view.getFrame().getPanel().getSaveButton().setVisible(true);
            view.getFrame().getPanel().getCancelButton().setVisible(true);
            //view.getFrame().getPanel().getEditButton().setVisible(false);
            view.getFrame().getPanel().getPatientInfoTextArea().setEditable(true);
            view.getFrame().getPanel().getSaveButton().setEnabled(false);
            view.getFrame().getPanel().getCancelButton().setEnabled(false);
            //view.getFrame().getPanel().getEditButton().setVisible(false);
            //view.getFrame().getPanel().getEditButton().setEnabled(false);
         }
     }
     
     private void hideEditSaveControlButtons(){
         patient.checkIsMinor();
         if (patient.getPermissions().canUpdateData){
            view.getFrame().getPanel().getSaveButton().setVisible(false);
            view.getFrame().getPanel().getCancelButton().setVisible(false);
            //view.getFrame().getPanel().getEditButton().setVisible(false);
            //view.getFrame().getPanel().getEditButton().setEnabled(false);
            view.getFrame().getPanel().getPatientInfoTextArea().setEditable(false);
            view.getFrame().getPanel().getSaveButton().setEnabled(false);
            view.getFrame().getPanel().getCancelButton().setEnabled(false);
         }
     }
            
    /**
     * @return the physician
     */
    public Physician getPhysician() {
        return physician;
    }

    /**
     * @param physician the physician to set
     */
    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    //action performed necessary for implementing action listener interface
    @Override
    public void actionPerformed(ActionEvent event) 
    {       	
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
  
}
