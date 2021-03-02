import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Login extends JFrame implements ActionListener{
    Inicio in = new Inicio();
    public JPanel loginPanel;
    public JTextField userTextField;
    public JPasswordField passJPass;
    public JLabel userLabel, passLabel, porfilePic;
    public JButton loginButton;
    public String userM = "mamarre", passM = "muchachota", userI, passI;
    public Login(){
        this.setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        screen();
    }//Elementos de la ventana
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == loginButton){
            userI = userTextField.getText();
            passI = new String(passJPass.getPassword());
            if(userI.equals(userM) && passI.equals(passM)){
                in.setVisible(true);
                setVisible(false);
            }
            else{
               JOptionPane.showMessageDialog(null, "Incorrecto");
            }
        }
    }//Eventos
    
    public void screen(){
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        this.getContentPane().add(loginPanel);
        
        ImageIcon porfile = new ImageIcon("./porfilePic/porfilePic.png");
        porfilePic = new JLabel();
        porfilePic.setBounds(175, 10, 50, 50);
        porfilePic.setIcon(new ImageIcon(porfile.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        loginPanel.add(porfilePic);
        
        userLabel = new JLabel();
        userLabel.setOpaque(true);
        userLabel.setText("user");
        userLabel.setBounds(20, 60, 360, 30);
        loginPanel.add(userLabel);
        
        passLabel = new JLabel();
        passLabel.setOpaque(true);
        passLabel.setText("pass");
        passLabel.setBounds(20, 140, 360, 30);
        loginPanel.add(passLabel);
        
        userTextField = new JTextField();
        userTextField.setBounds(20, 100, 360, 30);
        loginPanel.add(userTextField);
        
        passJPass = new JPasswordField();
        passJPass.setBounds(20, 180, 360, 30);
        loginPanel.add(passJPass);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 220, 100, 40);
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);
    }//Elementos de panel
}