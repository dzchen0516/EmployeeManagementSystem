package employee.management.system;

import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RemoveEmployeeScreen extends JFrame implements ActionListener {
    Choice allEmployeeID;
    JLabel nameField;
    JLabel phoneNumberField;
    JLabel emailField;
    JButton deleteButton;
    JButton backButton;
    RemoveEmployeeScreen() {

        //all employee id selection field
        add(createRemoveEmployeeScreenDetailsField("Employee ID", 50,50,100,30,"Tahoma",15));
        allEmployeeID = new Choice();
        allEmployeeID.setBounds(200,50,150,30);
        add(allEmployeeID);
        try {
            ArrayList<String> allEmployeeIds = DataSource.getAllEmployeeID();
            for(String employeeId : allEmployeeIds)
            {
                allEmployeeID.add(employeeId);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        //employee name field
        add(createRemoveEmployeeScreenDetailsField("Name", 50, 100, 100,30,"Tahoma",15));
        nameField = createUpdateEmployeeScreenLabel(200,100,150,30);
        add(nameField);

        //phone number field
        add(createRemoveEmployeeScreenDetailsField("Phone", 50, 150, 100,30,"Tahoma",15));
        phoneNumberField = createUpdateEmployeeScreenLabel(200,150,150,30);
        add(phoneNumberField);

        //email field
        add(createRemoveEmployeeScreenDetailsField("Email", 50, 200, 100,30,"Tahoma",15));
        emailField = createUpdateEmployeeScreenLabel(200,200,150,30);
        add(emailField);

        //populate employee info
        populateEmployeeInfo(allEmployeeID.getSelectedItem());

        //add listener to the employee id selection list
        allEmployeeID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    populateEmployeeInfo(allEmployeeID.getSelectedItem());
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        });

        //delete button
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(80, 300, 100, 30);
        deleteButton.addActionListener(this);
        add(deleteButton);


        //back button
        backButton = new JButton("Back");
        backButton.setBounds(220, 300, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        //delete image
        RawIconConverter removeIconImg = new RawIconConverter(700, 80, 200, 200, "icons/delete.png");
        JLabel removeImg = removeIconImg.convertIcons();
        add(removeImg);

        //background img
        RawIconConverter backgroundIconImg = new RawIconConverter(0, 0, 1120, 630, "icons/rback.png");
        JLabel backgroundImg = backgroundIconImg.convertIcons();
        add(backgroundImg);

        setSize(1000, 400);
        setLayout(null);
        setLocation(300, 150);
        setVisible(true);
    }

    static JLabel createRemoveEmployeeScreenDetailsField(String labelName, int x,
                                                         int y, int width, int height,
                                                         String fontName, int fontSize)
    {
        JLabel newLabel = new JLabel(labelName);
        newLabel.setBounds(x, y, width, height);
        newLabel.setFont(new Font(fontName, Font.BOLD, fontSize));

        return newLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deleteButton)
        {
            DataSource.deleteEmployeeByID(allEmployeeID.getSelectedItem());
            JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
            setVisible(false);
            new MainScreen();
        }
        else
        {
            setVisible(false);
        }
    }

    static JLabel createUpdateEmployeeScreenLabel(int x, int y, int width, int height)
    {
        JLabel newInputField = new JLabel();
        newInputField.setBounds(x, y, width, height);
        return newInputField;
    }

    void populateEmployeeInfo(String updateEmployeeID)
    {
        ArrayList<Object[]> allEmployee = DataSource.getEmployeeByID(updateEmployeeID);
        for(Object[] employeeInfo : allEmployee)
        {
            nameField.setText(employeeInfo[0].toString());
            phoneNumberField.setText(employeeInfo[5].toString());
            emailField.setText(employeeInfo[6].toString());
        }
    }

    public static void main(String[] args) {
        new RemoveEmployeeScreen();
    }
}
