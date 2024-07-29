package com.codewithmosh.command;

public class UndoCommand implements Command{
    private History commands;

    @Override
    public void execute() {
        if (commands.size() > 0) {
            commands.pop().unexecute();
        }
    }
}
