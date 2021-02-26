package ua.mushroom.hospital.command;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.RoleDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;
import ua.mushroom.hospital.validation.AuthValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Login command.
 *
 * @author Volodymyr
 */
public class LoginCommand implements Command{
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final RoleDAOImpl roleDAO = new RoleDAOImpl();
    private final AuthValidator authValidator = new AuthValidator();
    private final static Map<String, String> PATHS = new HashMap<>();

    static {
        PATHS.put("ADMIN", PathConstants.ADMIN_PAGE);
        PATHS.put("DOCTOR", PathConstants.DOCTOR_PAGE);
        PATHS.put("NURSE", PathConstants.NURSE_PAGE);
        PATHS.put("PATIENT", PathConstants.PATIENT_PAGE);
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userDAO.findByEmailAndPassword(email, password).orElse(null);

        boolean isSuccessful = authValidator.login(email, password, req, user);

        if (isSuccessful) {
            session.setAttribute("role",
                    roleDAO.findById(user.getRole_id()).getName());
            session.setAttribute("userId", user.getId());

            resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);

            String currentRole = (String) session.getAttribute("role");

            resp.setHeader("Location", PATHS.get(currentRole));
        }

        req.getRequestDispatcher(ViewConstants.LOGIN_VIEW).forward(req, resp);
    }
}
