package com.codetest.toyrobot;

import com.codetest.toyrobot.command.Command;
import com.codetest.toyrobot.game.Game;
import com.codetest.toyrobot.logger.RobotLogger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyRobotSimulator {

    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2) {
            showHelpInfo();
            System.exit(0);
        }

        if (args.length == 2) {
            if ("--detail".equals(args[1]) || "-d".equals(args[1])) {
                RobotLogger.enableDetails();
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

            List<Command> commands = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                Command command = Command.parseAndBuild(line);
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

    public static void showHelpInfo() {
        String helpInfo = "Usage: java -jar toyrobot-1.0 <fileName> [options]\n"
                + "\n"
                + "options: \n"
                + "    -d, --detail          Show details of the execution of the toy robot simulator\n";
        System.out.println(helpInfo);
    }
}
