package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.DoctorDAOImpl;
import ua.mushroom.hospital.dao.impl.PatientDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.DoctorInfo;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DoctorDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
        PatientDAOImpl patientDAO = new PatientDAOImpl();

        int id = Integer.parseInt(req.getParameter("id"));

        User user = userDAO.findById(id).get();
        DoctorInfo doctor = doctorDAO.findByUserId(id).get();
        List<User> patients = patientDAO.findAllUserByDoctorId(doctor.getId());

        req.setAttribute("user", user);
        req.setAttribute("category", doctor.getCategory());
        req.setAttribute("patients", patients);

        req.getRequestDispatcher(ViewConstants.DOCTOR_DETAILS_VIEW).forward(req, resp);
    }
}
