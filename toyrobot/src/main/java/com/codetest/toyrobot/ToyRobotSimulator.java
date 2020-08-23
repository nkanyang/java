package com.codetest.toyrobot;

import com.codetest.toyrobot.game.Game;
import com.codetest.toyrobot.input.CommandInput;
import com.codetest.toyrobot.input.ConsoleInput;
import com.codetest.toyrobot.input.FileInput;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ToyRobotSimulator {
    final static org.apache.log4j.Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        if (args.length > 2) {
            showHelpInfo();
            System.exit(0);
        }
        if (args.length == 2 && !"--log".equals(args[1]) && !"-l".equals(args[1])) {
            showHelpInfo();
            System.exit(0);
        }

        CommandInput input = getInput(args);
        if (input == null) {
            return;
        }
        Game toyRobot = new Game(5, 5);
        input.run(toyRobot);
    }

    public static CommandInput getInput(String[] args) {
        if (args.length == 0) {
            return new ConsoleInput();
        } else {
            String fileName = args[0];
            try {
                FileReader commandFile = new FileReader(fileName);
                BufferedReader br = new BufferedReader(commandFile);
                if (args.length == 2) {
                    logger.setLevel(Level.ALL);
                }
                return new FileInput(br);
            } catch (IOException e) {
                System.out.println("Can not find file: " + fileName);
                return null;
            }
        }
    }

    public static void showHelpInfo() {
        String helpInfo = "Usage: java -jar toyrobot.jar [<fileName> [options]]\n"
                + "\n"
                + "fileName:              Specify the file with commands;If not given, read command from console\n"
                + "options: \n"
                + "    -l, --log          Show log of the execution of the toy robot simulator when use file as input source\n";
        System.out.println(helpInfo);
    }
}
