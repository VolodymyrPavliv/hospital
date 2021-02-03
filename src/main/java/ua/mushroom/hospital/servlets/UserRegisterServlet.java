package ua.mushroom.hospital.servlets;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.dao.impl.RoleDAOImpl;
import ua.mushroom.hospital.dao.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();

        if(req.getParameter("doctorId") != null) {
            int doctorId = Integer.parseInt(req.getParameter("doctorId"));

            userDAO.addRoleId(doctorId, new RoleDAOImpl().findByName("DOCTOR").getId());
        }

        if(req.getParameter("nurseId")!=null) {
            int nurseId = Integer.parseInt(req.getParameter("nurseId"));

            userDAO.addRoleId(nurseId, new RoleDAOImpl().findByName("NURSE").getId());
        }

        if(req.getParameter("patientId") != null) {
            int patientId = Integer.parseInt(req.getParameter("patientId"));

            userDAO.addRoleId(patientId, new RoleDAOImpl().findByName("PATIENT").getId());
        }

        resp.sendRedirect(PathConstants.ADMIN_PAGE);
    }
}
