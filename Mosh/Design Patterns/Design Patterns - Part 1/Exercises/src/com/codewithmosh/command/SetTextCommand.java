package com.codewithmosh.command;

public class SetTextCommand extends Command {

    private String text;

    public SetTextCommand(VideoEditor editor, String text) {
        super(editor);
        this.text = text;
    }

    public void execute() {
        getEditor().setText(text);
    }
}
