package ua.mushroom.hospital.command;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class RegisterCommand implements Command{
    private final UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean added = addUser(req);

        if(added) {
            resp.sendRedirect(PathConstants.LOGIN);
            return;
        }

        req.getRequestDispatcher(ViewConstants.REGISTER_VIEW).forward(req, resp);
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
