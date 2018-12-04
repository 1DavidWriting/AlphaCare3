/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author kken1
 */
public class CaregiverFrame extends JFrame{
    
    private CaregiverPanel panel;
    
    CaregiverFrame(Caregiver caregiver) {
        
        super ("");
        //panel = new CaregiverPanel(newCaregiver);
        panel = new CaregiverPanel(caregiver);
        
        setSize(650,620);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //To set frame maximized by default:
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //To open the frame a bit further down and to the left of where it would normally open:  
        this.setLocation(300, 100);
        add(panel);
        
    }

    public CaregiverPanel getPanel() {
        
        return panel;
        
    }

    public void setPanel(CaregiverPanel panel) {
        
        this.panel = panel;
        
    }
    
}
