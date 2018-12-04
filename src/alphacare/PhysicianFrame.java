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
public class PhysicianFrame extends JFrame{
    
    private PhysicianPanel panel;
    
    PhysicianFrame(Physician physician) {
        
        super ("");
        panel = new PhysicianPanel(physician);
        
        setSize(650,620);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //To set frame maximized by default:
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //To open the frame a bit further down and to the left of where it would normally open:  
        this.setLocation(300, 100);
        add(panel);
        
    }

    public PhysicianPanel getPanel() {
        return panel;
    }

    public void setPanel(PhysicianPanel panel) {
        this.panel = panel;
    }

}

