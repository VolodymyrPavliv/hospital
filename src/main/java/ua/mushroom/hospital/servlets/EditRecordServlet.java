package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.dao.impl.RecordDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class EditRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RecordDAOImpl recordDAO = new RecordDAOImpl();

        int id = Integer.parseInt(req.getParameter("id"));

        if (req.getParameter("initialDiagnosis") != null) {
            String initialDiagnosis = req.getParameter("initialDiagnosis");

            recordDAO.addInitialDiagnosis(id, initialDiagnosis);
        }

        if (req.getParameter("finalDiagnosis") != null) {
            String finalDiagnosis = req.getParameter("finalDiagnosis");

            recordDAO.addFinalDiagnosis(id, finalDiagnosis);
            recordDAO.addDischargeDate(id, Date.valueOf(req.getParameter("dischargeDate")));
        }

        resp.sendRedirect(PathConstants.DOCTOR_RECORD_PAGE+"?recordId="+id);
    }
}
