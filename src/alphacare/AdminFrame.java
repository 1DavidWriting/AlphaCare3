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
public class AdminFrame extends JFrame{
    
    
    private AdminPanel panel;
    
    AdminFrame(Administrator admin) {
        
        super ("");
        panel = new AdminPanel(admin);
        
        setSize(550,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(panel);        
        
    }

    public AdminPanel getPanel() {
        
        return panel;
    
    }

    public void setPanel(AdminPanel panel) {
        
        this.panel = panel;
    
    }

}

