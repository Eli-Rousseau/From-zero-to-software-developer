package com.codewithmosh.command;

import java.util.List;

public class History {

    private List<UndoableCommand> commands;

    public void push(UndoableCommand command) {
        commands.add(command);
    }

    public UndoableCommand pop() {
        return commands.removeLast();
    }

    public int size() {
        return commands.size();
    }
}
