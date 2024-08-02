package com.codewithmosh.command;

public abstract class Command {

    private VideoEditor editor;

    public Command(VideoEditor editor) {
        this.editor = editor;
    }

    public VideoEditor getEditor() {
        return editor;
    }

    protected abstract void execute();
}
