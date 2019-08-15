package by.bsu.domino.constant;

import by.bsu.domino.command.ICommand;
import by.bsu.domino.command.LoginCommand;
import by.bsu.domino.command.LogoutCommand;

public enum CommandType {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand());

    private ICommand command;

    CommandType(ICommand command){
        this.command = command;
    }

    public ICommand getCommand(){
        return this.command;
    }

}
