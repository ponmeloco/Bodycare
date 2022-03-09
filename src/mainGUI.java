import javax.swing.*;
import java.awt.*;

public class mainGUI extends JFrame {
    private JPanel mainGuiPanel;

    mainGUI(){
        add(mainGuiPanel);
        Image bonusprogrammIcon = Toolkit.getDefaultToolkit().getImage("res/images/bonusIconTitle.png");
        setIconImage(bonusprogrammIcon);
        setTitle("Bodycare Statistics");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
