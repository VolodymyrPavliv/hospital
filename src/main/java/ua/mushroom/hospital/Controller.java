package ua.mushroom.hospital;


import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.command.container.CommandContainer;
import ua.mushroom.hospital.command.container.GetCommandContainer;
import ua.mushroom.hospital.command.container.PostCommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Main servlet controller
 *
 * @author Volodymyr Pavliv
 *
 */

public class Controller extends HttpServlet {
    private static final GetCommandContainer getCommand = new GetCommandContainer();
    private static final PostCommandContainer postCommand = new PostCommandContainer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        execute(req, resp, getCommand, uri);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        execute(req, resp, postCommand, uri);
    }

    /**
     *  Main method of this controller
     */
    private void execute(HttpServletRequest req, HttpServletResponse resp, CommandContainer container, String uri) throws ServletException, IOException {
        //extract command name by uri and execute it
        Command command = container.get(uri);
        command.execute(req, resp);
    }
}
