package by.bsu.domino.util;

import by.bsu.domino.command.ICommand;
import by.bsu.domino.constant.CommandType;

import java.util.Optional;

public class CommandDefiner {
    public static Optional<ICommand> defineCommand(String commandName){
        Optional<ICommand> command;

        if(commandName == null || commandName.isBlank()){
            return Optional.empty();
        }

        try{
            CommandType type =CommandType.valueOf(commandName.toUpperCase());
            command = Optional.of(type.getCommand());
        } catch(IllegalArgumentException e){
            command = Optional.empty();
        }

        return command;
    }
}
