package ua.mushroom.hospital.command.nurse;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Nurse's records command.
 *
 * @author Volodymyr
 */
public class NurseRecordsCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDAOImpl userDAO = new UserDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();

        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User user = userDAO.findById(userId).get();

        req.setAttribute("user", user);
        req.setAttribute("records", recordDAO.findByNurseId(user.getId()));
        req.setAttribute("currentRole", session.getAttribute("role"));
        req.setAttribute("isNurse", true);
        req.getRequestDispatcher(ViewConstants.RECORDS_VIEW).forward(req,resp);
    }
}
