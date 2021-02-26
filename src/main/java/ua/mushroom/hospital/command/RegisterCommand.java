package ua.mushroom.hospital.command;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;
import ua.mushroom.hospital.validation.AuthValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Register command.
 *
 * @author Volodymyr
 */
public class RegisterCommand implements Command{
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final AuthValidator authValidator = new AuthValidator();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();

        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        if(!req.getParameter("birthday").isEmpty()) {
            user.setBirthday(Date.valueOf(req.getParameter("birthday")));
        }
        String confirmPassword = req.getParameter("confirmPassword");

        boolean isRegister = authValidator.register(user, confirmPassword, req);

        if(isRegister) {
            userDAO.addUser(user);
            resp.sendRedirect(PathConstants.LOGIN);
            return;
        }

        req.getRequestDispatcher(ViewConstants.REGISTER_VIEW).forward(req, resp);
    }

}
