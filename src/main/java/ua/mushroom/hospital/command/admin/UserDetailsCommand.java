package ua.mushroom.hospital.command.admin;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.DoctorInfoDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RoleDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.DoctorInfo;
import ua.mushroom.hospital.db.entity.Role;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * User details command.
 *
 * @author Volodymyr
 */
public class UserDetailsCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        DoctorInfoDAOImpl doctorInfoDAO = new DoctorInfoDAOImpl();
        RoleDAOImpl roleDAO = new RoleDAOImpl();

        int userId = 0;

        if(req.getParameter("userId") == null) {
            req.getRequestDispatcher(ViewConstants.ADMIN_PAGE).forward(req, resp);
        }

        userId = Integer.parseInt(req.getParameter("userId"));

        User user = userDAO.findById(userId).get();
        Role role = roleDAO.findById(user.getRole_id());

        if(role.getName().equals("DOCTOR")) {
            DoctorInfo doctorInfo = doctorInfoDAO.findByUserId(user.getId()).get();

            req.setAttribute("doctorInfoId", doctorInfo.getId());
            req.setAttribute("category", doctorInfo.getCategory());
        }

        req.setAttribute("user", user);
        req.setAttribute("role", role.getName());
        req.setAttribute("userId",userId);

        req.getRequestDispatcher(ViewConstants.USER_DETAILS_VIEW).forward(req, resp);
    }
}
