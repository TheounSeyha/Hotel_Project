import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login2 extends JFrame {
    private JLabel labelName = new JLabel("User name ");
    private JLabel labelPassWord = new JLabel("Password ");
    private JTextField textName = new JFormattedTextField();
    private JPasswordField textPassword = new JPasswordField();
    private JButton buttonLogin = new JButton("Login");
    private JButton buttonExit = new JButton("Exit");

    private int error = 0;

    public Login2() {

        // Set the frame properties
        setTitle("Login Form");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create the main panel with a green background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0, 204, 153));
        mainPanel.setLayout(null);

        // Create the header panel with a gray background and red "Login" text
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setBounds(0, 0, 400, 100);
        headerPanel.setLayout(null);
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 36));
        loginLabel.setForeground(Color.RED);
        loginLabel.setBounds(150, 30, 100, 40);
        headerPanel.add(loginLabel);

        // Create the form panel with white background
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 120, 300, 300);
        formPanel.setLayout(null);

        // User icon
        ImageIcon userIcon = new ImageIcon("\"C:\\Users\\USER\\Desktop\\ASSINGMENT\\Hotelproject\\src\\iconmonstr-eye-9.png\""); // Replace with your user icon path
        JLabel userIconLabel = new JLabel(userIcon);
        userIconLabel.setBounds(30, 20, 32, 32);
        formPanel.add(userIconLabel);

        // Password icon
        ImageIcon passwordIcon = new ImageIcon("\"C:\\Users\\USER\\Desktop\\ASSINGMENT\\Hotelproject\\src\\eye.png\""); // Replace with your password icon path
        JLabel passwordIconLabel = new JLabel(passwordIcon);
        passwordIconLabel.setBounds(30, 80, 32, 32);
        formPanel.add(passwordIconLabel);

        // Username field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(70, 20, 200, 32);
        formPanel.add(usernameField);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(70, 80, 200, 32);
        formPanel.add(passwordField);

        // Show password checkbox
        JCheckBox showPassword = new JCheckBox();
        showPassword.setBounds(40, 140, 20, 20);
        formPanel.add(showPassword);

        // Eye icon
        ImageIcon eyeIcon = new ImageIcon("\"C:\\Users\\USER\\Desktop\\ASSINGMENT\\Hotelproject\\src\\iconmonstr-eye-9.png\""); // Replace with your eye icon path
        JLabel eyeIconLabel = new JLabel(eyeIcon);
        eyeIconLabel.setBounds(70, 140, 32, 32);
        formPanel.add(eyeIconLabel);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 0, 204));
        loginButton.setForeground(Color.WHITE);
        //loginButton.setBounds(100, 200, 100, 40);
        formPanel.add(loginButton);

        loginButton.setBounds(150,200,100,40);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.CYAN);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBounds(50,200,100,40);
        formPanel.add(exitButton);

        // Add panels to the main panel
        mainPanel.add(headerPanel);
        mainPanel.add(formPanel);

        // Add the main panel to the frame
        add(mainPanel);

        // Show password action
        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().isEmpty() && new String(passwordField.getPassword()).isEmpty()) {
                    new Hotel();
                } else {
                    if (error <= 2) {
                        error += 1;
                        JOptionPane.showMessageDialog(null, "Wrong Account!");
                    } else {
                        passwordField.setEnabled(false);
                        usernameField.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "You have entered too many wrong!");
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login2().setVisible(true);
        });
    }
}
