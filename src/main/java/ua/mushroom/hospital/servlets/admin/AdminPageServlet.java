package ua.mushroom.hospital.servlets.admin;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.RoleDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        RoleDAOImpl roleDAO = new RoleDAOImpl();

        List<User> unregisteredUsers = userDAO.findAll().stream()
                .filter(u->u.getRole_id()==0).collect(Collectors.toList());

        List<User> doctors = userDAO.findAllByRoleId(roleDAO.findByName("DOCTOR")
                .getId());
        List<User> nurses = userDAO.findAllByRoleId(roleDAO.findByName("NURSE")
                .getId());
        List<User> patients = userDAO.findAllByRoleId(roleDAO.findByName("PATIENT")
                .getId());

        req.setAttribute("doctors",doctors);
        req.setAttribute("nurses",nurses);
        req.setAttribute("patients",patients);
        req.setAttribute("unregisteredUsers",unregisteredUsers);

        req.getRequestDispatcher(ViewConstants.ADMIN_PAGE).forward(req, resp);
    }
}
