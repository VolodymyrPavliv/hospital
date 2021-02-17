package ua.mushroom.hospital.command;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.db.dao.impl.AssignmentDAOImpl;
import ua.mushroom.hospital.db.entity.Assignment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

public class AddAssignmentCommand implements Command{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Assignment assignment = new Assignment();
        AssignmentDAOImpl assignmentDAO = new AssignmentDAOImpl();

        int recordId = Integer.parseInt(req.getParameter("recordId"));
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        String roleName = session.getAttribute("role").toString();

        assignment.setType(req.getParameter("type"));
        assignment.setDescription(req.getParameter("description"));
        assignment.setDate(Date.valueOf(req.getParameter("date")));
        assignment.setUserId(userId);
        assignment.setRecordId(recordId);

        assignmentDAO.addAssignment(assignment);

        if(roleName.equals("DOCTOR")) {
            resp.sendRedirect(PathConstants.DOCTOR_RECORD_PAGE + "?recordId=" + recordId);
        }

        if(roleName.equals("NURSE")) {
            resp.sendRedirect(PathConstants.NURSE_RECORD_PAGE + "?recordId=" + recordId);
        }
    }
}
