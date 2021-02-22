package ua.mushroom.hospital.command.admin;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.DoctorInfoDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RecordDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RoleDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.DoctorInfo;
import ua.mushroom.hospital.db.entity.Record;
import ua.mushroom.hospital.db.entity.Role;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordListCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDAOImpl userDAO = new UserDAOImpl();
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        DoctorInfoDAOImpl doctorInfoDAO = new DoctorInfoDAOImpl();

        List<Record> records = new ArrayList<>();

        int userId = 0;

        if(req.getParameter("userId") == null) {
            req.getRequestDispatcher(ViewConstants.ADMIN_PAGE).forward(req, resp);
        }

        userId = Integer.parseInt(req.getParameter("userId"));

        User user = userDAO.findById(userId).get();
        Role role = roleDAO.findById(user.getRole_id());

        if(role.getName().equals("NURSE")) {
            records = recordDAO.findByNurseId(user.getId());
        }

        if(role.getName().equals("PATIENT")) {
            records = recordDAO.findByPatientId(user.getId());
        }

        if(role.getName().equals("DOCTOR")) {
            DoctorInfo doctorInfo = doctorInfoDAO.findByUserId(user.getId()).get();
            records = recordDAO.findByDoctorId(doctorInfo.getId());
        }

        req.setAttribute("records", records);
        req.setAttribute("userId", userId);
        req.setAttribute("userRole", role.getName());
        req.setAttribute("isAdmin", true);
        req.getRequestDispatcher(ViewConstants.RECORDS_VIEW).forward(req, resp);
    }
}
