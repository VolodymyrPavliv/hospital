package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> users = userDAO.findAll();

        List<User> registeredUsers = new ArrayList<>();
        List<User> unregisteredUsers = new ArrayList<>();

        for (User user : users) {
            if(user.getRole_id()>0) {
                registeredUsers.add(user);
            }else {
                unregisteredUsers.add(user);
            }
        }

        req.setAttribute("registeredUsers",registeredUsers);
        req.setAttribute("unregisteredUsers",unregisteredUsers);

        req.getRequestDispatcher(ViewConstants.ADMIN_PAGE).forward(req, resp);
    }
}
