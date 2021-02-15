package ua.mushroom.hospital.servlets.admin;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.AssignmentDAOImpl;
import ua.mushroom.hospital.dao.impl.DoctorInfoDAOImpl;
import ua.mushroom.hospital.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.Assignment;
import ua.mushroom.hospital.entities.DoctorInfo;
import ua.mushroom.hospital.entities.Record;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        UserDAOImpl userDAO = new UserDAOImpl();
        DoctorInfoDAOImpl doctorInfoDAO = new DoctorInfoDAOImpl();
        AssignmentDAOImpl assignmentDAO = new AssignmentDAOImpl();

        int recordId = Integer.parseInt(req.getParameter("recordId"));

        Record record = recordDAO.findById(recordId).get();
        User patient = userDAO.findById(record.getPatientId()).get();
        DoctorInfo doctorInfo = doctorInfoDAO.findId(record.getDoctorId()).get();
        User doctor = userDAO.findById(doctorInfo.getUserId()).get();
        User nurse = userDAO.findById(record.getNurseId()).get();
        List<Assignment> assignments = assignmentDAO.findByRecordId(recordId);

        req.setAttribute("record", record);
        req.setAttribute("patient", patient);
        req.setAttribute("doctorInfo", doctorInfo);
        req.setAttribute("doctor", doctor);
        req.setAttribute("nurse", nurse);
        req.setAttribute("assignments", assignments);

        req.getRequestDispatcher(ViewConstants.RECORD_DETAILS_VIEW).forward(req, resp);
    }
}
