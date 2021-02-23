package ua.mushroom.hospital.command.nurse;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.AssignmentDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.entity.Assignment;
import ua.mushroom.hospital.db.entity.Record;
import ua.mushroom.hospital.validation.AssignmentValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

public class NurseAssignmentCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Assignment assignment = new Assignment();
        AssignmentDAOImpl assignmentDAO = new AssignmentDAOImpl();
        AssignmentValidator validator = new AssignmentValidator();
        RecordDAOImpl recordDAO = new RecordDAOImpl();

        int recordId = Integer.parseInt(req.getParameter("recordId"));
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        Record record = recordDAO.findById(recordId).get();

        String description = "";
        if(req.getParameter("description")!= null) {
            description = req.getParameter("description");
        }

        Date date = null;

        if(!req.getParameter("date").isEmpty()) {
            date = Date.valueOf(req.getParameter("date"));
        }

        boolean correctValidation = validator.addAssignment(description, date, req);

        if(correctValidation) {
            assignment.setType(req.getParameter("type"));
            assignment.setDescription(description);
            assignment.setDate(date);
            assignment.setUserId(userId);
            assignment.setRecordId(recordId);
            assignmentDAO.addAssignment(assignment);
            resp.sendRedirect(PathConstants.NURSE_ASSIGNMENTS_PAGE + "?recordId=" + recordId);
            return;
        }

        req.setAttribute("record", record);
        req.setAttribute("isNurse", true);
        req.getRequestDispatcher(ViewConstants.ADD_ASSIGNMENT).forward(req, resp);
    }
}
