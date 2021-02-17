package ua.mushroom.hospital.command.patient;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.AssignmentDAOImpl;
import ua.mushroom.hospital.db.dao.impl.DoctorInfoDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.Assignment;
import ua.mushroom.hospital.db.entity.DoctorInfo;
import ua.mushroom.hospital.db.entity.Record;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientRecordCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        req.setAttribute("isPatient", true);

        req.getRequestDispatcher(ViewConstants.RECORD_DETAILS_VIEW).forward(req, resp);
    }
}
