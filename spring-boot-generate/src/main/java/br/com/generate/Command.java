package br.com.generate;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by ivanmarreta on 03/11/16.
 */
public enum Command {

    GENERATE_MODEL("model"),
    GENERATE_REPOSITORY("repository"),
    GENERATE_SERVICE("service"),
    GENERATE_CONTROLLER("controller"),
    GENERATE_SCAFFOLD("scaffold"),
    GENERATE_PROJECT("init");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command getCommand(String command){
        Optional<Command> commandOptional = Arrays.stream(Command.values()).filter(c -> c.getCommand().equals(command)).findFirst();
        return commandOptional.get();
    }

}
