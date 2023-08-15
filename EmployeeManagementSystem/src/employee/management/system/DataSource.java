package employee.management.system;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class DataSource {
    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "cdz330011");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static String getEmployeeByName(String username) {
        String sqlStmt = "select * from login where username = ?";
        String password = "";
        try(Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sqlStmt)) {
            statement.setString(1, username);
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next())
                {
                    password = resultSet.getString("password");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return password;
    }

    public static ArrayList<Object[]> getEmployeeByID(String empId) {
        ArrayList<Object[]> oneEmployee = new ArrayList<>();
        String sqlStmt = "select * from employee where employeeId = ?";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlStmt)) {
            statement.setString(1, empId);
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next())
                {
                    String name = resultSet.getString("name");
                    String fatherName = resultSet.getString("fname");
                    String birthday = resultSet.getString("birthday");
                    String salary = resultSet.getString("salary");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    String education = resultSet.getString("education");
                    String position = resultSet.getString("position");
                    String ID = resultSet.getString("id");
                    String employeeId = resultSet.getString("employeeId");

                    Object[] employee = {name, fatherName, birthday, salary, address,
                            phone, email, education, position, ID,
                            employeeId};

                    oneEmployee.add(employee);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return oneEmployee;
    }

    public static void addEmployee(String name, String fatherName, String birthday,
                                   String salary, String address, String phone,
                                   String email, String education, String position,
                                   String ID, String employeeID) {
        String sqlStmt = "insert into employee values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlStmt)) {
            statement.setString(1, name);
            statement.setString(2, fatherName);
            statement.setString(3, birthday);
            statement.setString(4, salary);
            statement.setString(5, address);
            statement.setString(6, phone);
            statement.setString(7, email);
            statement.setString(8, education);
            statement.setString(9, position);
            statement.setString(10, ID);
            statement.setString(11, employeeID);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getAllEmployeeID() {
        ArrayList<String> allEmployeeIDs = new ArrayList<>();
        String sqlStmt = "select * from employee";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlStmt)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next())
                {
                    allEmployeeIDs.add(resultSet.getString("employeeId"));
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return allEmployeeIDs;
    }

    public static ArrayList<Object[]> getAllEmployeeData() {
        ArrayList<Object[]> allEmployee = new ArrayList<>();
        String sqlStmt = "select * from employee";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlStmt)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next())
                {
                    String name = resultSet.getString("name");
                    String fatherName = resultSet.getString("fname");
                    String birthday = resultSet.getString("birthday");
                    String salary = resultSet.getString("salary");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    String education = resultSet.getString("education");
                    String position = resultSet.getString("position");
                    String ID = resultSet.getString("id");
                    String employeeId = resultSet.getString("employeeId");

                    Object[] employee = {name, fatherName, birthday, salary, address,
                                            phone, email, education, position, ID,
                                                employeeId};

                    allEmployee.add(employee);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return allEmployee;
    }

    public static void updateEmployeeByID(String employeeId, String fatherName, String salary,
                                          String address, String phone, String email,
                                          String education, String position) {
        String sqlStmt = "update employee set fname = ?, salary = ?, address = ?, phone = ?, email = ?, education = ?, position = ? where employeeId = ?";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlStmt)) {
            statement.setString(1, fatherName);
            statement.setString(2, salary);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.setString(5, email);
            statement.setString(6, education);
            statement.setString(7, position);
            statement.setString(8, employeeId);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteEmployeeByID(String employeeId)
    {
        String sqlStmt = "delete from employee where employeeId = ?";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlStmt)) {
            statement.setString(1, employeeId);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
