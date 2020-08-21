package com.codetest.toyrobot;

import com.codetest.toyrobot.commands.Command;
import com.codetest.toyrobot.commands.CommandParser;
import com.codetest.toyrobot.game.Game;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyRobotSimulator {
    final static org.apache.log4j.Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2) {
            showHelpInfo();
            System.exit(0);
        }

        logger.setLevel(Level.OFF);
        if (args.length == 2) {
            if ("--log".equals(args[1]) || "-l".equals(args[1])) {
                logger.setLevel(Level.ALL);
            } else {
                showHelpInfo();
                System.exit(1);
            }
        }

        String fileName = args[0];
        FileReader commandFile = null;
        try {
            commandFile = new FileReader(fileName);
            BufferedReader br = new BufferedReader(commandFile);
            CommandParser commandParser = new CommandParser();

            logger.info("Begin parsing commands from file " + fileName);
            List<Command> commands = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                Command command = commandParser.buildFromString(line);
                if (command == null) {
                    logger.error(line + " is not a valid command.Skipped");
                    continue;
                }
                logger.info(line + " is parsed successfully.");
                commands.add(command);
            }
            logger.info("Done parsing commands.");

            logger.info("Start game, execute all commands ...");
            Game toyRobot = new Game(5, 5);
            commands.forEach(toyRobot::executeCommand);
        } catch (IOException e) {
            System.out.println("Can not find file: " + fileName);
            System.exit(1);
        }
    }

    public static void showHelpInfo() {
        String helpInfo = "Usage: java -jar toyrobot.jar <fileName> [options]\n"
                + "\n"
                + "options: \n"
                + "    -l, --log          Show log of the execution of the toy robot simulator\n";
        System.out.println(helpInfo);
    }
}
