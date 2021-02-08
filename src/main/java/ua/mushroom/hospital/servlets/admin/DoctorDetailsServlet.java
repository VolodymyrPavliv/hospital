package ua.mushroom.hospital.servlets.admin;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.DoctorInfoDAOImpl;
import ua.mushroom.hospital.dao.impl.RecordDAOImpl;
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
        DoctorInfoDAOImpl doctorDAO = new DoctorInfoDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();

        int id = Integer.parseInt(req.getParameter("id"));

        User doctor = userDAO.findById(id).get();
        DoctorInfo doctorInfo = doctorDAO.findByUserId(id).get();
        List<User> patients = recordDAO.findPatientsByDoctorId(doctorInfo.getId());

        req.setAttribute("doctor", doctor);
        req.setAttribute("category", doctorInfo.getCategory());
        req.setAttribute("patients", patients);

        req.getRequestDispatcher(ViewConstants.DOCTOR_DETAILS_VIEW).forward(req, resp);
    }
}
