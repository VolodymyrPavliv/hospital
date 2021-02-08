package ua.mushroom.hospital.servlets.admin;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PatientDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        
        User patient = userDAO.findById(Integer.parseInt(req.getParameter("id"))).get();
        User doctor = recordDAO.findDoctorByPatientId(patient.getId()).get();
        User nurse = recordDAO.findNurseByPatientId(patient.getId()).get();

        req.setAttribute("patient", patient);
        req.setAttribute("doctor", doctor);
        req.setAttribute("nurse", nurse);

        req.getRequestDispatcher(ViewConstants.PATIENT_DETAILS_VIEW).forward(req, resp);
    }
}
