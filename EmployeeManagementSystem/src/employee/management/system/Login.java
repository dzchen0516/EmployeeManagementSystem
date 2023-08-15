package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JTextField userNameField;
    JPasswordField passwordField;

    JButton loginButton;
    JButton backButton;
    Login() {
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        userNameField = new JTextField();
        userNameField.setBounds(150, 20, 150, 30);
        add(userNameField);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 140, 150, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        backButton = new JButton("BACK");
        backButton.setBounds(150, 180, 150, 30);
        backButton.addActionListener(this);
        add(backButton);

        RawIconConverter employeeIconBackgroundImg = new RawIconConverter(350,10,600, 400, "icons/employeeIcon.jpg");
        add(employeeIconBackgroundImg.convertIcons());

        RawIconConverter loginImg = new RawIconConverter(0,0,600, 300, "icons/LoginB.jpg");
        add(loginImg.convertIcons());

        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton)
        {
            try {
                String username = userNameField.getText();
                String password = passwordField.getText();

                if(Authenticator.login(username, password))
                {
                    setVisible(false);
                    new MainScreen();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else if(e.getSource() == backButton)
        {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
