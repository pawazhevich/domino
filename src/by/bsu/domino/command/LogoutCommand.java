package by.bsu.domino.command;

import by.bsu.domino.constant.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return PagePath.LOGIN;
    }
}
