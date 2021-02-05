package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.NurseDAOImpl;
import ua.mushroom.hospital.dao.impl.PatientDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.NurseInfo;
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
        NurseDAOImpl nurseDAO = new NurseDAOImpl();
        PatientDAOImpl patientDAO = new PatientDAOImpl();

        int id = Integer.parseInt(req.getParameter("id"));

        User user = userDAO.findById(id).get();
        NurseInfo nurse = nurseDAO.findByUserId(id).get();
        List<User> patients = patientDAO.findAllUserByDoctorId(nurse.getId());

        req.setAttribute("user", user);
        req.setAttribute("patients", patients);

        req.getRequestDispatcher(ViewConstants.NURSE_DETAILS_VIEW).forward(req, resp);
    }
}
