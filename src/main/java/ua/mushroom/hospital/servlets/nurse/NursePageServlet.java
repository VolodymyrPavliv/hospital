package ua.mushroom.hospital.servlets.nurse;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.Record;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NursePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        RecordDAOImpl recordDAO = new RecordDAOImpl();
        UserDAOImpl userDAO = new UserDAOImpl();

        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User nurse = userDAO.findById(userId).get();

        req.setAttribute("user", nurse);
        req.setAttribute("records", recordDAO.findByNurseId(nurse.getId()));

        req.getRequestDispatcher(ViewConstants.NURSE_PAGE).forward(req, resp);
    }
}
