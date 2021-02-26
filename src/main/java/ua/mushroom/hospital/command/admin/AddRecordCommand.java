package ua.mushroom.hospital.command.admin;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.entity.Record;
import ua.mushroom.hospital.validation.RecordValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Add record command.
 *
 * @author Volodymyr
 */
public class AddRecordCommand implements Command {
    private final RecordValidator recordValidator = new RecordValidator();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        Record record = new Record();

        String doctorId = req.getParameter("doctorId");
        String nurseId = req.getParameter("nurseId");
        String userId = req.getParameter("userId");
        String role = req.getParameter("role");

        Date entryDate = null;

        if(!req.getParameter("entryDate").isEmpty()) {
            entryDate  = Date.valueOf(req.getParameter("entryDate"));
        }

        boolean correctValidation = recordValidator.addRecord(doctorId, nurseId, entryDate, req);

        if(correctValidation) {
            record.setPatientId(Integer.parseInt(userId));
            record.setDoctorId(Integer.parseInt(doctorId));
            record.setNurseId(Integer.parseInt(nurseId));
            record.setEntryDate(entryDate);

            recordDAO.addRecord(record);

            resp.sendRedirect(PathConstants.RECORD_LIST_PAGE+"?role="+role+"&userId="+userId);
            return;
        }

        req.setAttribute("patientId", userId);
        req.setAttribute("userId", userId);
        req.getRequestDispatcher(ViewConstants.ADD_RECORD_VIEW).forward(req, resp);
    }
}
