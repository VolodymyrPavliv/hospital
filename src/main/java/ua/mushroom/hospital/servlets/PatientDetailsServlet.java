package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.DoctorDAOImpl;
import ua.mushroom.hospital.dao.impl.NurseDAOImpl;
import ua.mushroom.hospital.dao.impl.PatientDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.DoctorInfo;
import ua.mushroom.hospital.entities.NurseInfo;
import ua.mushroom.hospital.entities.PatientInfo;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        PatientDAOImpl patientDAO = new PatientDAOImpl();
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        int id = Integer.parseInt(req.getParameter("id"));

        User user = userDAO.findById(id).get();
        PatientInfo patientInfo = patientDAO.findByUserId(id).get();
        DoctorInfo doctorInfo = doctorDAO.findById(patientInfo.getDoctorId()).get();
        User doctor = userDAO.findById(doctorInfo.getUserId()).get();

        req.setAttribute("user", user);
        req.setAttribute("doctor", doctor);

        req.getRequestDispatcher(ViewConstants.PATIENT_DETAILS_VIEW).forward(req, resp);
    }
}
