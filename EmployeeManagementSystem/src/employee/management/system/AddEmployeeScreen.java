package employee.management.system;

import com.sun.tools.javac.Main;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployeeScreen extends JFrame implements ActionListener {

    JTextField nameField;
    JTextField fatherNameField;
    JTextField salaryField;
    JTextField addressField;
    JTextField phoneNumberField;
    JTextField emailField;
    JTextField idNumberField;
    JTextField positionField;
    JLabel employeeIDNumberField;
    JDateChooser birthdayChooserField;
    JComboBox educationField;
    JButton addButton;
    JButton backButton;

    AddEmployeeScreen() {
        getContentPane().setBackground(new Color(163, 255, 188));

        //Add Employee screen heading
        add(createAddEmployeeScreenDetailsField("Add Employee Details", 320, 30, 500,50, "serif", 25));

        //name field
        add(createAddEmployeeScreenDetailsField("Name", 50, 150, 150,30,"SAN_SERIF",20));
        nameField = createAddEmployeeScreenTextField(200,150,150,30);
        add(nameField);

        //father's name field
        add(createAddEmployeeScreenDetailsField("Father's Name", 400, 150, 150,30,"SAN_SERIF",20));
        fatherNameField = createAddEmployeeScreenTextField(600,150,150,30);
        add(fatherNameField);

        //birthday field
        add(createAddEmployeeScreenDetailsField("Date of Birth", 50, 200, 150,30,"SAN_SERIF",20));
        birthdayChooserField = new JDateChooser();
        birthdayChooserField.setBounds(200,200,150,30);
        birthdayChooserField.setBackground(new Color(177, 252, 197));
        add(birthdayChooserField);

        //salary field
        add(createAddEmployeeScreenDetailsField("Salary", 400, 200, 150,30,"SAN_SERIF",20));
        salaryField = createAddEmployeeScreenTextField(600,200,150,30);
        add(salaryField);

        //address field
        add(createAddEmployeeScreenDetailsField("Address", 50, 250, 150,30,"SAN_SERIF",20));
        addressField = createAddEmployeeScreenTextField(200,250,150,30);
        add(addressField);

        //phone number field
        add(createAddEmployeeScreenDetailsField("Phone", 400, 250, 150,30,"SAN_SERIF",20));
        phoneNumberField = createAddEmployeeScreenTextField(600,250,150,30);
        add(phoneNumberField);

        //email field
        add(createAddEmployeeScreenDetailsField("Email", 50, 300, 150,30,"SAN_SERIF",20));
        emailField = createAddEmployeeScreenTextField(200,300,150,30);
        add(emailField);

        //education field
        add(createAddEmployeeScreenDetailsField("Highest Education", 400, 300, 150,30,"SAN_SERIF",20));
        String educationLevel[] = {"BBA", "BCA", "BA", "BSC", "MBA", "MA", "PHD"};
        educationField = new JComboBox(educationLevel);
        educationField.setBackground(new Color(177, 252, 197));
        educationField.setBounds(600, 300, 150, 30);
        add(educationField);

        //id number field
        add(createAddEmployeeScreenDetailsField("ID Number", 400, 350, 150,30,"SAN_SERIF",20));
        idNumberField = createAddEmployeeScreenTextField(600,350,150,30);
        add(idNumberField);

        //employee id number field
        add(createAddEmployeeScreenDetailsField("Employee ID", 50, 400, 150,30,"SAN_SERIF",20));
        Random rand = new Random();
        int randomEmployeeIDNum = rand.nextInt(999999);
        employeeIDNumberField = new JLabel("" +  randomEmployeeIDNum);
        employeeIDNumberField.setBounds(200, 400, 150, 30);
        employeeIDNumberField.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        employeeIDNumberField.setForeground(Color.RED);
        add(employeeIDNumberField);

        //position field
        add(createAddEmployeeScreenDetailsField("Position", 50, 350, 150,30,"SAN_SERIF",20));
        positionField = createAddEmployeeScreenTextField(200,350,150,30);
        add(positionField);

        //back button
        backButton = new JButton("Back");
        backButton.setBounds(250, 550, 150, 40);
        backButton.addActionListener(this);
        add(backButton);

        //add button
        addButton = new JButton("Add");
        addButton.setBounds(450, 550, 150, 40);
        addButton.addActionListener(this);
        add(addButton);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton)
        {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String birthday = ((JTextField) birthdayChooserField.getDateEditor().getUiComponent()).getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneNumberField.getText();
            String email = emailField.getText();
            String education = (String) educationField.getSelectedItem();
            String position = positionField.getText();
            String ID = idNumberField.getText();
            String employeeId = employeeIDNumberField.getText();

            try{
                DataSource.addEmployee(name, fatherName, birthday, salary, address,
                        phone, email, education, position, ID, employeeId);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new MainScreen();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new MainScreen();
        }
    }

    static JLabel createAddEmployeeScreenDetailsField(String labelName, int x,
                                                      int y, int width, int height,
                                                      String fontName, int fontSize)
    {
        JLabel newLabel = new JLabel(labelName);
        newLabel.setBounds(x, y, width, height);
        newLabel.setFont(new Font(fontName, Font.BOLD, fontSize));

        return newLabel;
    }

    static JTextField createAddEmployeeScreenTextField(int x, int y, int width, int height)
    {
        JTextField newInputField = new JTextField();
        newInputField.setBounds(x, y, width, height);
        newInputField.setBackground(new Color(177,252,197));
        return newInputField;
    }

    public static void main(String[] args) {
        new AddEmployeeScreen();
    }
}
