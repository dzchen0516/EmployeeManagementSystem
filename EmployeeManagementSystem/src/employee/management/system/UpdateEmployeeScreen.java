package employee.management.system;

import com.sun.tools.javac.Main;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class UpdateEmployeeScreen extends JFrame implements ActionListener {
    JLabel nameField;
    JTextField fatherNameField;
    JLabel birthdayField;
    JTextField salaryField;
    JTextField addressField;
    JTextField phoneNumberField;
    JTextField emailField;
    JTextField educationField;
    JLabel idNumberField;
    JTextField positionField;
    JLabel employeeIDNumberField;
    JButton updateButton;
    JButton backButton;
    String updateEmployeeID;
    UpdateEmployeeScreen(String updateEmployeeID) {
        this.updateEmployeeID = updateEmployeeID;

        getContentPane().setBackground(new Color(163, 255, 188));

        //Add Employee screen heading
        add(createUpdateEmployeeScreenDetailsField("Update Employee Details", 320, 30, 500,50, "serif", 25));

        //name field
        add(createUpdateEmployeeScreenDetailsField("Name", 50, 150, 150,30,"SAN_SERIF",20));
        nameField = createUpdateEmployeeScreenLabel(200,150,150,30);
        add(nameField);

        //father's name field
        add(createUpdateEmployeeScreenDetailsField("Father's Name", 400, 150, 150,30,"SAN_SERIF",20));
        fatherNameField = createUpdateEmployeeScreenTextField(600,150,150,30);
        add(fatherNameField);

        //birthday field
        add(createUpdateEmployeeScreenDetailsField("Date of Birth", 50, 200, 150,30,"SAN_SERIF",20));
        birthdayField = createUpdateEmployeeScreenLabel(200,200,150,30);
        birthdayField.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(birthdayField);

        //salary field
        add(createUpdateEmployeeScreenDetailsField("Salary", 400, 200, 150,30,"SAN_SERIF",20));
        salaryField = createUpdateEmployeeScreenTextField(600,200,150,30);
        add(salaryField);

        //address field
        add(createUpdateEmployeeScreenDetailsField("Address", 50, 250, 150,30,"SAN_SERIF",20));
        addressField = createUpdateEmployeeScreenTextField(200,250,150,30);
        add(addressField);

        //phone number field
        add(createUpdateEmployeeScreenDetailsField("Phone", 400, 250, 150,30,"SAN_SERIF",20));
        phoneNumberField = createUpdateEmployeeScreenTextField(600,250,150,30);
        add(phoneNumberField);

        //email field
        add(createUpdateEmployeeScreenDetailsField("Email", 50, 300, 150,30,"SAN_SERIF",20));
        emailField = createUpdateEmployeeScreenTextField(200,300,150,30);
        add(emailField);

        //education field
        add(createUpdateEmployeeScreenDetailsField("Highest Education", 400, 300, 150,30,"SAN_SERIF",20));
        educationField = createUpdateEmployeeScreenTextField(600,300,150,30);
        add(educationField);

        //id number field
        add(createUpdateEmployeeScreenDetailsField("ID Number", 400, 350, 150,30,"SAN_SERIF",20));
        idNumberField = createUpdateEmployeeScreenLabel(600,350,150,30);
        add(idNumberField);

        //employee id number field
        add(createUpdateEmployeeScreenDetailsField("Employee ID", 50, 400, 150,30,"SAN_SERIF",20));
        employeeIDNumberField = createUpdateEmployeeScreenLabel(200,400,150,30);
        employeeIDNumberField.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        employeeIDNumberField.setForeground(Color.RED);
        add(employeeIDNumberField);

        //position field
        add(createUpdateEmployeeScreenDetailsField("Position", 50, 350, 150,30,"SAN_SERIF",20));
        positionField = createUpdateEmployeeScreenTextField(200,350,150,30);
        add(positionField);

        populateEmployeeInfo(updateEmployeeID);

        //back button
        backButton = new JButton("Back");
        backButton.setBounds(250, 550, 150, 40);
        backButton.addActionListener(this);
        add(backButton);

        //add button
        updateButton = new JButton("Update");
        updateButton.setBounds(450, 550, 150, 40);
        updateButton.addActionListener(this);
        add(updateButton);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateButton)
        {
            String fatherName = fatherNameField.getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneNumberField.getText();
            String email = emailField.getText();
            String education = educationField.getText();
            String position = positionField.getText();

            try {
                DataSource.updateEmployeeByID(updateEmployeeID, fatherName, salary,
                        address, phone, email, education, position);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new MainScreen();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new MainScreen();
        }
    }

    static JLabel createUpdateEmployeeScreenDetailsField(String labelName, int x,
                                                         int y, int width, int height,
                                                         String fontName, int fontSize)
    {
        JLabel newLabel = new JLabel(labelName);
        newLabel.setBounds(x, y, width, height);
        newLabel.setFont(new Font(fontName, Font.BOLD, fontSize));

        return newLabel;
    }

    static JTextField createUpdateEmployeeScreenTextField(int x, int y, int width, int height)
    {
        JTextField newInputField = new JTextField();
        newInputField.setBounds(x, y, width, height);
        newInputField.setBackground(new Color(177,252,197));
        return newInputField;
    }

    static JLabel createUpdateEmployeeScreenLabel(int x, int y, int width, int height)
    {
        JLabel newInputField = new JLabel();
        newInputField.setBounds(x, y, width, height);
        newInputField.setBackground(new Color(177,252,197));
        return newInputField;
    }

    void populateEmployeeInfo(String updateEmployeeID)
    {
        ArrayList<Object[]> allEmployee = DataSource.getEmployeeByID(updateEmployeeID);
        for(Object[] employeeInfo : allEmployee)
        {
            nameField.setText(employeeInfo[0].toString());
            fatherNameField.setText(employeeInfo[1].toString());
            birthdayField.setText(employeeInfo[2].toString());
            salaryField.setText(employeeInfo[3].toString());
            addressField.setText(employeeInfo[4].toString());
            phoneNumberField.setText(employeeInfo[5].toString());
            emailField.setText(employeeInfo[6].toString());
            educationField.setText(employeeInfo[7].toString());
            positionField.setText(employeeInfo[8].toString());
            idNumberField.setText(employeeInfo[9].toString());
            employeeIDNumberField.setText(employeeInfo[10].toString());
        }
    }

    public static void main(String[] args) {
        new UpdateEmployeeScreen("");
    }
}
