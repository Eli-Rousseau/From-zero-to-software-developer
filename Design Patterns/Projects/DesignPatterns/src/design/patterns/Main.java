package design.patterns;

import design.patterns.memento.Editor;
import design.patterns.memento.History;

public class Main {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        editor.setContent("Eli");
        history.push(editor.createState());

        editor.setContent("Mariam");
        history.push(editor.createState());

        editor.setContent("Ester");
        editor.restore(history.pop());
        editor.restore(history.pop());
        System.out.println(editor.getContent());
    }
}
