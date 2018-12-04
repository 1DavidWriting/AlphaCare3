/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

/**
 *
 * @author kken1
 */
public class CaregiverView {
    
    private CaregiverFrame frame;

    public CaregiverView(Caregiver caregiver) {
        
        frame = new CaregiverFrame(caregiver);
        
    }

    public CaregiverFrame getFrame() {
        
        return frame;
        
    }

    public void setFrame(CaregiverFrame frame) {
        
        this.frame = frame;
        
    }

}
