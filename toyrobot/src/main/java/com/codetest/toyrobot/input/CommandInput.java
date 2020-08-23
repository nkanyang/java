package com.codetest.toyrobot.input;

import com.codetest.toyrobot.commands.CommandParser;
import com.codetest.toyrobot.game.Game;

public abstract class CommandInput {
    protected CommandParser commandParser;

    public CommandInput() {
        this.commandParser = new CommandParser();
    }

    public abstract void run(Game toyRobot);
}
