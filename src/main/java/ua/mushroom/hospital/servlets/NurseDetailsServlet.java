package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NurseDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();

        int id = Integer.parseInt(req.getParameter("id"));

        User nurse = userDAO.findById(id).get();
        List<User> patients = recordDAO.findPatientsByNurseId(nurse.getId());

        req.setAttribute("nurse", nurse);
        req.setAttribute("patients", patients);

        req.getRequestDispatcher(ViewConstants.NURSE_DETAILS_VIEW).forward(req, resp);
    }
}
