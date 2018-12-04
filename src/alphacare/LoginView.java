
package alphacare;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Swaggy Daggy Gaming
 */
public class LoginView extends JFrame {
    private JButton loginButton;
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JFrame frame;
    
    public LoginView(){
        frame = new JFrame("AlphaCare");

        
            
        JLabel pageTitle = new JLabel("Login");
        pageTitle.setFont(pageTitle.getFont().deriveFont(24.0f));
        pageTitle.setBounds(90, 10, 200, 30);
            
        JLabel userIDTitle = new JLabel("UserID");
        userIDTitle.setBounds(20, 50, 200, 30);
            
        JLabel passwordTitle = new JLabel("Password");
        passwordTitle.setBounds(20, 80, 200, 30);
            
        userIDField = new JTextField();
        userIDField.setBounds(90, 50, 200, 30);
            
        passwordField = new JPasswordField();
        passwordField.setBounds(90, 80, 200, 30);
            
        loginButton = new JButton("login");
        loginButton.setBounds(190, 120, 100, 30);
            
        frame.add(pageTitle);
        frame.add(userIDTitle);
        frame.add(passwordTitle);
        frame.add(userIDField);
        frame.add(passwordField);
        frame.add(loginButton);
              
        frame.setSize(320, 200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
            
        }
    
    public void clearFields(){
        this.getUserIDField().setText("");
        this.getPasswordField().setText("");
    }

    /**
     * @return the loginButton
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    /**
     * @return the userIDField
     */
    public JTextField getUserIDField() {
        return userIDField;
    }

    /**
     * @param userIDField the userIDField to set
     */
    public void setUserIDField(JTextField userIDField) {
        this.userIDField = userIDField;
    }

    /**
     * @return the passwordField
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * @param passwordField the passwordField to set
     */
    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
}
