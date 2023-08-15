package employee.management.system;

import javax.security.auth.login.LoginException;
public class Authenticator {
    public static boolean login(String username, String password) {
        String employeePassword = DataSource.getEmployeeByName(username);
        if (employeePassword.isEmpty() || !password.equals(employeePassword)) {
            return false;
        }
        return true;
    }

}
