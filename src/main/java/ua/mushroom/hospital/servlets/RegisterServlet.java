package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class RegisterServlet extends HttpServlet {
    private final UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ViewConstants.REGISTER_VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean added = addUser(req);

        if(added) {
            resp.sendRedirect("/login");
            return;
        }

        doGet(req, resp);
    }

    private boolean addUser(HttpServletRequest req) {
        User newUser = new User();

        newUser.setName(req.getParameter("name"));
        newUser.setSurname(req.getParameter("surname"));
        newUser.setEmail(req.getParameter("email"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setBirthday(Date.valueOf(req.getParameter("birthday")));

        return userDAO.addUser(newUser);
    }


}
