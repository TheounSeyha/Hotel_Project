import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JLabel labelName = new JLabel("User name ");
    private JLabel labelPassWord = new JLabel("Password ");
    private JTextField textName = new JFormattedTextField();
    private JPasswordField textPassword = new JPasswordField();
    private Button buttonLogin = new Button("Login");
    private Button buttonExit = new Button("Exit");


    int error = 0;
    public Login() {

        setSize(500,300);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        add(labelName);
        add(textName);
        add(labelPassWord);
        add(textPassword);
        add(buttonExit);
        add(buttonLogin);
        labelName.setBackground(Color.pink);
        buttonExit.setBackground(Color.CYAN);
        buttonLogin.setBackground(Color.cyan);
        labelName.setBounds(40,50,90,30);
        labelPassWord.setBounds(40,100,90,30);
        textName.setBounds(110,50,120,30);
        textPassword.setBounds(110,100,120,30);
        buttonExit.setBounds(100,200,100,50);
        buttonLogin.setBounds(200,200,100,50);

        textPassword.setEchoChar('+');
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( (textName.getText().compareTo("") == 0)
                        && (textPassword.getText().compareTo("")==0)){
                    new Hotel();
                }else {
                    if (error<=2){
                        error+=1;
                        JOptionPane.showMessageDialog(null,"Wrong Account!");
                    }else {
                        textPassword.enable(false);
                        textName.enable(false);
                        JOptionPane.showMessageDialog(null,"You have entered too many wrong! ");
                    }
                }
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
