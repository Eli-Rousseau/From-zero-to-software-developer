package com.codewithmosh.command;

public class SetContrastCommand extends Command {

    private int contrast;

    public SetContrastCommand(VideoEditor editor, int contrast) {
        super(editor);
        this.contrast = contrast;
    }

    public void execute() {
        getEditor().setContrast(contrast);
    }
}
