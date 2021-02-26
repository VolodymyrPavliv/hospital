package ua.mushroom.hospital.validation;

import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * The validator for logging and registration
 *
 * @author Volodymyr Pavliv
 */
public class AuthValidator {
    UserDAOImpl userDAO = new UserDAOImpl();
    private static final String PASSWORD_REGEX = "^.{4,8}$";

    public boolean login(String email, String password, HttpServletRequest request, User user) {
        if(email.isEmpty() || password.isEmpty()) {
            request.setAttribute("emptyCredentials", true);
            return false;
        }

        if(user.getName() == null) {
            request.setAttribute("loginIncorrectCredentials", true);
            return false;
        }

        if(user.getRole_id()==0) {
            request.setAttribute("notRegisteredYet", true);
            return false;
        }

        return true;
    }

    public boolean register(User user, String confirmPassword, HttpServletRequest request) {
        User userByEmail = userDAO.findByEmail(user.getEmail()).orElse(null);

        if(!user.getPassword().matches(PASSWORD_REGEX)) {
            request.setAttribute("passwordIncorrect", true);
            return false;
        }

        if(user.getName().isEmpty() || user.getSurname().isEmpty() || confirmPassword.isEmpty()
                || user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getBirthday() == null) {
            request.setAttribute("emptyCredentials", true);
            return false;
        }

        if(!user.getPassword().equals(confirmPassword)) {
            request.setAttribute("passwordsDontMatch", true);
            return false;
        }

        if (userByEmail != null && userByEmail.getEmail() != null) {
            request.setAttribute("emailExists", true);
            return false;
        }

        return true;
    }
}
