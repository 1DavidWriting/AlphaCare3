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
public class PhysicianView {

    private PhysicianFrame frame;

    public PhysicianView(Physician physician) {
        
        frame = new PhysicianFrame(physician);
        
    }

    public PhysicianFrame getFrame() {
        return frame;
    }

    public void setFrame(PhysicianFrame frame) {
        this.frame = frame;
    }

}
