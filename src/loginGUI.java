import javax.swing.*;
import java.awt.*;

public class loginGUI extends JFrame{
    private JTextField loginUsernameTextField;
    private JPanel loginPanel;
    private JPasswordField loginPasswordField;
    private JButton loginLoginButton;
    private JLabel loingUsernameLabel;
    private JLabel loginPasswordLabel;

    loginGUI(){
        loginLoginButton.setText("Login");
        loingUsernameLabel.setText("Username");
        loginPasswordLabel.setText("Password");
        loginPanel.setBackground(Color.PINK);

        add(loginPanel);
        Image bonusprogrammIcon = Toolkit.getDefaultToolkit().getImage("res/images/bonusIconTitle.png");
        setBackground(Color.PINK);
        setIconImage(bonusprogrammIcon);
        setTitle("Bodycare Bonusprogramm");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }
    public static void main(String[] args) {
        loginGUI loginGUI = new loginGUI();
    }

}
