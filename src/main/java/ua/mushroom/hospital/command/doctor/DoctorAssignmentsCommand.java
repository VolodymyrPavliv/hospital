package ua.mushroom.hospital.command.doctor;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.AssignmentDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.entity.Assignment;
import ua.mushroom.hospital.db.entity.Record;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * Doctor's assignments command.
 *
 * @author Volodymyr
 */
public class DoctorAssignmentsCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        AssignmentDAOImpl assignmentDAO = new AssignmentDAOImpl();

        int recordId = Integer.parseInt(req.getParameter("recordId"));

        Record record = recordDAO.findById(recordId).get();
        List<Assignment> assignments = assignmentDAO.findByRecordId(recordId);

        req.setAttribute("record", record);
        req.setAttribute("assignments", assignments);
        req.setAttribute("isDoctor", true);

        req.getRequestDispatcher(ViewConstants.ASSIGNMENTS_VIEW).forward(req, resp);
    }
}
