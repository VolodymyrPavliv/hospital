package ua.mushroom.hospital.command.doctor;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.validation.RecordValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Add final diagnosis command.
 *
 * @author Volodymyr
 */
public class AddFinalDiagnosisCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        RecordValidator validator = new RecordValidator();

        int id = 0;

        if(req.getParameter("id")!=null) {
            id = Integer.parseInt(req.getParameter("id"));
        }

        String finalDiagnosis = "";

        if(req.getParameter("finalDiagnosis")!=null) {
            finalDiagnosis = req.getParameter("finalDiagnosis");
        }

        Date date = null;

        if(!req.getParameter("dischargeDate").isEmpty()) {
            date = Date.valueOf(req.getParameter("dischargeDate"));
        }


        boolean correctValidation = validator.addFinalDiagnosis(finalDiagnosis, date, req);


        if(correctValidation) {
            recordDAO.addFinalDiagnosis(id, finalDiagnosis);
            recordDAO.addDischargeDate(id, date);
            resp.sendRedirect(PathConstants.DOCTOR_RECORD_PAGE + "?recordId=" + id);
            return;
        }

        req.setAttribute("id", id);
        req.getRequestDispatcher(ViewConstants.ADD_FINAL_DIAGNOSIS).forward(req, resp);
    }
}
