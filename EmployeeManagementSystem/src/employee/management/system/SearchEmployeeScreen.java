package employee.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchEmployeeScreen extends JFrame implements ActionListener {

    Choice allEmployeeID;
    JTable employeeTable;
    JButton searchButton;
    JButton printButton;
    JButton updateButton;
    JButton backButton;
    String[] columnNames = {"Name", "Father's Name", "Birthday", "Salary", "Address", "Phone",
            "Email", "Education", "Position", "ID", "EmployeeID"};
    SearchEmployeeScreen() {
        getContentPane().setBackground(new Color(255, 131, 122));

        //heading
        JLabel searchEmployeeHeading = new JLabel("Search by employee id");
        searchEmployeeHeading.setBounds(20, 20, 150, 20);
        add(searchEmployeeHeading);

        //all employee ID selection
        allEmployeeID = new Choice();
        allEmployeeID.setBounds(180, 20, 150, 20);
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

        //employee table
        employeeTable = new JTable();
        add(createEmployeeSearchResultTable(employeeTable, columnNames));

        //search button
        searchButton = new JButton("Search");
        searchButton.setBounds(20, 70, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);

        //print button
        printButton = new JButton("Print");
        printButton.setBounds(120, 70, 80, 20);
        printButton.addActionListener(this);
        add(printButton);

        //update button
        updateButton = new JButton("Update");
        updateButton.setBounds(220, 70, 80, 20);
        updateButton.addActionListener(this);
        add(updateButton);

        //back button
        backButton = new JButton("Back");
        backButton.setBounds(320, 70, 80, 20);
        backButton.addActionListener(this);
        add(backButton);



        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton)
        {
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            ArrayList<Object[]> employeeInfo = DataSource.getEmployeeByID(allEmployeeID.getSelectedItem());
            tableModel.addRow(employeeInfo.get(0));
            employeeTable.setModel(tableModel);
        }
        else if(e.getSource() == printButton)
        {
            try {
                employeeTable.print();
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else if(e.getSource() == updateButton)
        {
            setVisible(false);
            new UpdateEmployeeScreen(allEmployeeID.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new MainScreen();
        }
    }

    private static JScrollPane createEmployeeSearchResultTable(JTable employeeTable, String[] columnNames) {

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        ArrayList<Object[]> allEmployee = DataSource.getAllEmployeeData();
        for(Object[] employeeInfo : allEmployee)
        {
            tableModel.addRow(employeeInfo);
        }
        employeeTable.setModel(tableModel);

        JScrollPane employeeTablePane = new JScrollPane(employeeTable);
        employeeTablePane.setBounds(0, 100, 900, 400);
        return employeeTablePane;
    }

    public static void main(String[] args) {
        new SearchEmployeeScreen();
    }
}
