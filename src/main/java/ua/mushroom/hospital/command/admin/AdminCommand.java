package ua.mushroom.hospital.command.admin;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.constants.ViewConstants;
import ua.mushroom.hospital.db.dao.impl.UserDAOImpl;
import ua.mushroom.hospital.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();

        List<User> unregisteredUsers = userDAO.findAll().stream()
                .filter(u->u.getRole_id()==0).collect(Collectors.toList());
        req.setAttribute("unregisteredUsers",unregisteredUsers);

        req.getRequestDispatcher(ViewConstants.ADMIN_PAGE).forward(req, resp);
    }
}
