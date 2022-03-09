import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class loginGUI extends JFrame{

    private JTextField loginUsernameTextField;
    private JPanel loginPanel;
    private JPasswordField loginPasswordField;
    private JButton loginLoginButton;
    private JLabel loingUsernameLabel;
    private JLabel loginPasswordLabel;


    loginGUI() throws ClassNotFoundException, SQLException {

        if(Files.notExists(Paths.get("kunden_datenbank_bodycare.db"))){
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:kunden_datenbank_bodycare.db");
            assert false;
            sqlQueries sql = new sqlQueries();
            System.out.println("Building database...");
            sql.createUserTable(con);
            sql.createBonus(con);
            sql.createKundenUmsatzTable(con);
            sql.createKundenTable(con);
            sql.createProdukt(con);
            String s = "I`mmdr1///>";
            StringBuilder ss = new StringBuilder();
            for(int i = 0; i <= s.length()-1; i++){
                int c = s.charAt(i);
                c += 1;
                ss.append((char) c);
            }
            sql.insertUser("Linda",bcrypt.hashpw(ss.toString(),bcrypt.gensalt(10)),con);
            con.close();
        }

        loginLoginButton.setText("Login");
        getRootPane().setDefaultButton(loginLoginButton);
        loingUsernameLabel.setText("Username");
        loginPasswordLabel.setText("Password");
        loginPanel.setBackground(Color.PINK);
        loginLoginButton.addActionListener(e -> {
            try {
                Class.forName("org.sqlite.JDBC");
                Connection con = DriverManager.getConnection("jdbc:sqlite:kunden_datenbank_bodycare.db");
                String sql = "select * from user where Username = '"+loginUsernameTextField.getText()+"';";
                assert false;
                PreparedStatement prepStat = con.prepareStatement(sql);
                ResultSet resultSet = prepStat.executeQuery();
                if(resultSet.next() && bcrypt.checkpw(String.valueOf(loginPasswordField.getPassword()),resultSet.getString(3)) && loginUsernameTextField.getText().equals(resultSet.getString(2))){
                    JOptionPane.showMessageDialog(loginPanel,"Login successfully. Hello "+resultSet.getString(2)+"!","Login",JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    new mainGUI();
                } else JOptionPane.showMessageDialog(loginPanel,"Wrong credentials! Try again.","Error",JOptionPane.WARNING_MESSAGE);
                con.close();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        add(loginPanel);
        setBackground(new Color(255,187,154));
        Image bonusprogrammIcon = Toolkit.getDefaultToolkit().getImage("res/images/bonusIconTitle.png");
        setIconImage(bonusprogrammIcon);
        setTitle("Bodycare Statistics");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new loginGUI();
    }

}
