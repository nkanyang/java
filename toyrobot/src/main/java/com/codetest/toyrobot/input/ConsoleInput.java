package com.codetest.toyrobot.input;

import com.codetest.toyrobot.commands.Command;
import com.codetest.toyrobot.game.Game;

import java.util.Scanner;

public class ConsoleInput extends CommandInput {
    private final String prompt = "Enter a command(place x,y,[north|south|west|east]/move/right/left/report/exit):";
    private final Scanner scanner;

    public ConsoleInput() {
        super();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(Game toyRobot) {
        System.out.println("Please enter command for the toy robot simulator, enter exit if you want to end the game.");
        while (true) {
            System.out.println(this.prompt);
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            Command command = this.commandParser.buildFromString(input.toUpperCase());
            if (command == null) {
                System.out.println("Invalid Command!");
                continue;
            }
            toyRobot.executeCommand(command);
        }

    }
}
