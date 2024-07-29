package com.codewithmosh.command;

public class SetTextCommand implements UndoableCommand{
    private String previousContent;
    private VideoEditor videoEditor;
    private History commands;

    public SetTextCommand(VideoEditor videoEditor, History commands) {
        this.videoEditor = videoEditor;
        this.commands = commands;
    }

    @Override
    public void unexecute() {
        videoEditor.setText(previousContent);
    }

    @Override
    public void execute() {
        previousContent = videoEditor.getText();
        commands.push(this);
        videoEditor.setText("text");
    }
}
