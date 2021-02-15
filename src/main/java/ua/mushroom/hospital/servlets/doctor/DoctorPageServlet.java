package ua.mushroom.hospital.servlets.doctor;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.DoctorInfoDAOImpl;
import ua.mushroom.hospital.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.DoctorInfo;
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

public class DoctorPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDAOImpl userDAO = new UserDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        DoctorInfoDAOImpl doctorInfoDAO = new DoctorInfoDAOImpl();

        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User user = userDAO.findById(userId).get();
        DoctorInfo doctorInfo = doctorInfoDAO.findByUserId(user.getId()).get();

        req.setAttribute("user", user);
        req.setAttribute("records", recordDAO.findByDoctorId(doctorInfo.getId()));
        req.setAttribute("doctorInfoId", doctorInfo.getId());
        req.setAttribute("category", doctorInfo.getCategory());

        req.getRequestDispatcher(ViewConstants.DOCTOR_PAGE).forward(req,resp);
    }
}
