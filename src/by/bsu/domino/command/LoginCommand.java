package by.bsu.domino.command;

import by.bsu.domino.constant.PagePath;
import by.bsu.domino.dao.UserDao;
import by.bsu.domino.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req){
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();
        Optional<User> optionalUser =  userDao.isExist(login, password);

        if(optionalUser.isEmpty()){
            //TODO consts of login errors
            req.setAttribute("loginError", "Неверный логин и/или пароль");
            return PagePath.LOGIN;
        } else {
            req.getSession().setAttribute("user", optionalUser.get());
        }

        return PagePath.MAIN;
    }
}
