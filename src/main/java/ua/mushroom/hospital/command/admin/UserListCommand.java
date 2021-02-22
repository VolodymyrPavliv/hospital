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
import java.util.*;
import java.util.stream.Collectors;

public class UserListCommand implements Command {
    static Map<Integer, Comparator<User>> sorting = new HashMap<>();

    static {
        sorting.put(1, Comparator.comparing(User::getName));
        sorting.put(2, Comparator.comparing(u-> u.getDoctorInfo().getCategory()));
        sorting.put(3, Comparator.comparing(User::getBirthday));
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("listType").equals("doctorList")) {
            req.setAttribute("doctors", getUsers(req, "DOCTOR"));
            req.getRequestDispatcher(ViewConstants.DOCTORS_VIEW).forward(req, resp);
        }

        if (req.getParameter("listType").equals("patientList")) {
            req.setAttribute("patients", getUsers(req, "PATIENT"));
            req.getRequestDispatcher(ViewConstants.PATIENTS_VIEW).forward(req, resp);
        }

        if (req.getParameter("listType").equals("nurseList")) {
            req.setAttribute("nurses", getUsers(req,"NURSE"));
            req.getRequestDispatcher(ViewConstants.NURSES_VIEW).forward(req, resp);
        }
    }

    private List<User> getUsers(HttpServletRequest req, String roleName) {
        UserDAOImpl userDAO = new UserDAOImpl();
        RoleDAOImpl roleDAO = new RoleDAOImpl();

        int type = 0;

        if(req.getParameter("sortingType")!=null) {
            type = Integer.parseInt(req.getParameter("sortingType"));
        }

        List<User> users = userDAO.findAllByRoleId(roleDAO.findByName(roleName)
                .getId());

        return type==0?users:users.stream().sorted(sorting.get(type)).collect(Collectors.toList());
    }
}
