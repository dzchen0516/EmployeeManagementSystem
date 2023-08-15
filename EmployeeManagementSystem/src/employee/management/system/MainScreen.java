package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    JLabel homeImg;
    MainScreen() {
        RawIconConverter homeIconImg = new RawIconConverter(0, 0, 1120, 630, "icons/home.jpg");
        homeImg = homeIconImg.convertIcons();
        add(homeImg);

        JLabel mainScreenHeading = new JLabel("Employee Management System");
        mainScreenHeading.setBounds(340, 155, 400, 40);
        mainScreenHeading.setFont(new Font("Raleway", Font.BOLD, 25));
        homeImg.add(mainScreenHeading);

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBounds(335,270,150,40);
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployeeScreen();
                setVisible(false);
            }
        });
        homeImg.add(addEmployeeButton);

        JButton searchEmployeeButton = new JButton("Search Employee");
        searchEmployeeButton.setBounds(565,270,150,40);
        searchEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployeeScreen();
                setVisible(false);
            }
        });
        homeImg.add(searchEmployeeButton);

        JButton removeEmployeeButton = new JButton("Remove Employee");
        removeEmployeeButton.setBounds(440,370,150,40);
        removeEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployeeScreen();
            }
        });
        homeImg.add(removeEmployeeButton);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public static void main(String []args) {
        new MainScreen();
    }
}
