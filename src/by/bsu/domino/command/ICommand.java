package by.bsu.domino.command;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
    String execute(HttpServletRequest req);
}
