package com.codetest.toyrobot;

import com.codetest.toyrobot.command.Command;
import com.codetest.toyrobot.command.CommandParser;
import com.codetest.toyrobot.game.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToyRobotSimulator {
    private final static Logger rootLogger = Logger.getLogger("");

    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2) {
            showHelpInfo();
            System.exit(0);
        }

        disableLogging();
        if (args.length == 2) {
            if ("--log".equals(args[1]) || "-l".equals(args[1])) {
                enableLogging();
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

            List<Command> commands = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                Command command = commandParser.buildFromString(line);
                if (command != null) {
                    commands.add(command);
                }
            }

            Game toyRobot = new Game(5, 5);
            commands.forEach(toyRobot::executeCommand);
        } catch (IOException e) {
            System.out.println("Can not find file: " + fileName);
            System.exit(1);
        }
    }

    public static void disableLogging() {
        rootLogger.setLevel(Level.OFF);
    }

    public static void enableLogging() {
        rootLogger.setLevel(Level.ALL);
    }

    public static void showHelpInfo() {
        String helpInfo = "Usage: java -jar toyrobot-1.0 <fileName> [options]\n"
                + "\n"
                + "options: \n"
                + "    -l, --log          Show log of the execution of the toy robot simulator\n";
        System.out.println(helpInfo);
    }
}
