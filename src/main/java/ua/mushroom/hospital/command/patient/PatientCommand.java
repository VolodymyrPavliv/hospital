package ua.mushroom.hospital.command.patient;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.Record;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDAOImpl userDAO = new UserDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();

        List<Record> records = new ArrayList<>();

        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User user = userDAO.findById(userId).get();
        records = recordDAO.findByPatientId(user.getId());

        req.setAttribute("user", user);
        req.setAttribute("records", records);

        req.getRequestDispatcher(ViewConstants.PATIENT_PAGE).forward(req, resp);
    }
}
