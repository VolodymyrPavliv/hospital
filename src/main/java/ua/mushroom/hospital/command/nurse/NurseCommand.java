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

public class NurseCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserDAOImpl userDAO = new UserDAOImpl();

        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User nurse = userDAO.findById(userId).get();

        req.setAttribute("user", nurse);

        req.getRequestDispatcher(ViewConstants.NURSE_PAGE).forward(req, resp);
    }
}
