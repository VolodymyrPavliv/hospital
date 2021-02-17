package ua.mushroom.hospital.command;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.RoleDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LoginCommand implements Command{
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final RoleDAOImpl roleDAO = new RoleDAOImpl();
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

        Optional<User> user = userDAO.findByEmailAndPassword(email, password);

        if(user.isPresent() && user.get().getRole_id()==0) {
            req.setAttribute("not_registered_yet", true);
            req.getRequestDispatcher(ViewConstants.LOGIN_VIEW).forward(req, resp);
            return;
        }

        if (user.isPresent() && email != null && password != null) {
            session.setAttribute("role",
                    roleDAO.findById(user.get().getRole_id()).getName());
            session.setAttribute("userId", user.get().getId());

            resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);

            String currentRole = (String) session.getAttribute("role");

            resp.setHeader("Location", PATHS.get(currentRole));
        }

        req.getRequestDispatcher(ViewConstants.LOGIN_VIEW).forward(req, resp);
    }
}
