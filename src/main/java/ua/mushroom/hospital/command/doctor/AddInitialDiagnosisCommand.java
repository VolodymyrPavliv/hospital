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

public class AddInitialDiagnosisCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        RecordValidator validator = new RecordValidator();

        int id = 0;

        if(req.getParameter("id")!=null) {
            id = Integer.parseInt(req.getParameter("id"));
        }

        String initialDiagnosis = "";

        if(req.getParameter("initialDiagnosis")!=null) {
            initialDiagnosis = req.getParameter("initialDiagnosis");
        }

        boolean correctValidation = validator.addInitDiagnosis(initialDiagnosis, req);


        if(correctValidation) {
            recordDAO.addInitialDiagnosis(id, initialDiagnosis);
            resp.sendRedirect(PathConstants.DOCTOR_RECORD_PAGE + "?recordId=" + id);
            return;
        }

        req.setAttribute("id", id);
        req.getRequestDispatcher(ViewConstants.ADD_INIT_DIAGNOSIS).forward(req, resp);
    }
}
