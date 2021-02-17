package ua.mushroom.hospital.command.admin;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.DoctorInfoDAOImpl;
import ua.mushroom.hospital.db.dao.impl.RoleDAOImpl;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdminCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type = 0;

        if(req.getParameter("type")!=null) {
            type = Integer.parseInt(req.getParameter("type"));
        }

        UserDAOImpl userDAO = new UserDAOImpl();
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        DoctorInfoDAOImpl doctorInfoDAO = new DoctorInfoDAOImpl();

        List<User> unregisteredUsers = userDAO.findAll().stream()
                .filter(u->u.getRole_id()==0).collect(Collectors.toList());

        List<User> doctors = userDAO.findAllByRoleId(roleDAO.findByName("DOCTOR")
                .getId());
        List<User> nurses = userDAO.findAllByRoleId(roleDAO.findByName("NURSE")
                .getId());
        List<User> patients = userDAO.findAllByRoleId(roleDAO.findByName("PATIENT")
                .getId());

        if(type == 1) {
            doctors.sort(Comparator.comparing(User::getName));
        }

        if(type == 2) {
            doctors.sort(Comparator.comparing(d ->
                    doctorInfoDAO.findByUserId(d.getId()).get().getCategory()));
        }

        if(type == 3) {
            nurses.sort(Comparator.comparing(User::getName));
        }

        if(type == 4) {
            nurses.sort(Comparator.comparing(User::getBirthday));
        }

        if(type == 5) {
            patients.sort(Comparator.comparing(User::getName));
        }

        if(type == 6) {
            patients.sort(Comparator.comparing(User::getBirthday));
        }

        req.setAttribute("doctors",doctors);
        req.setAttribute("nurses",nurses);
        req.setAttribute("patients",patients);
        req.setAttribute("unregisteredUsers",unregisteredUsers);

        req.getRequestDispatcher(ViewConstants.ADMIN_PAGE).forward(req, resp);
    }
}