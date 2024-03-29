package by.bsu.domino.controller;

import by.bsu.domino.command.ICommand;
import by.bsu.domino.util.CommandDefiner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String commandName = req.getParameter("command");
        Optional<ICommand> commandOptional = CommandDefiner.defineCommand(commandName);

        req.getRemoteAddr();

        ICommand command = commandOptional.get();

        String page = command.execute(req);

        if(page != null){
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
            req.setAttribute("testParam","PARAM");

        } else {
            req.setAttribute("nullPage", "Page not found");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }
}
