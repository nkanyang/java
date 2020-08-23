package com.codetest.toyrobot.input;

import com.codetest.toyrobot.commands.Command;
import com.codetest.toyrobot.game.Game;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class FileInput extends CommandInput {
    final static Logger logger = Logger.getLogger(CommandInput.class.getName());
    private final BufferedReader reader;

    public FileInput(BufferedReader bufferedReader) {
        super();
        this.reader = bufferedReader;
    }

    @Override
    public void run(Game toyRobot) {
        String line;
        try {
            while ((line = this.reader.readLine()) != null) {
                Command command = commandParser.buildFromString(line);
                if (command == null) {
                    logger.error(line + " is not a valid command.Skipped");
                    continue;
                }
                toyRobot.executeCommand(command);
            }
        } catch (IOException e) {
            return;
        }
    }
}
