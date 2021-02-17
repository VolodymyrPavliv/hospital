package ua.mushroom.hospital.command.admin;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.entity.Record;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class AddRecordCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        Record record = new Record();

        int patientId = Integer.parseInt(req.getParameter("userId"));
        record.setPatientId(patientId);
        record.setDoctorId(Integer.parseInt(req.getParameter("doctorId")));
        record.setNurseId(Integer.parseInt(req.getParameter("nurseId")));
        record.setEntryDate(Date.valueOf(req.getParameter("entryDate")));

        recordDAO.addRecord(record);

        resp.sendRedirect(PathConstants.USER_DETAILS_PAGE+"?userId="+patientId);
    }
}