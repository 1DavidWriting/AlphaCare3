
package alphacare;

/**
 *
 * @author kken1
 */
public class AdminView {
    
    private AdminFrame frame;

    public AdminView(Administrator admin) {
        
        frame = new AdminFrame(admin);
        
    }

    public AdminFrame getFrame() {
        
        return frame;
        
    }

    public void setFrame(AdminFrame frame) {
        
        this.frame = frame;
        
    }
    
}
