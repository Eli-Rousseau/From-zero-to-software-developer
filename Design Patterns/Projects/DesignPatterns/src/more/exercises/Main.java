package more.exercises;

import more.exercises.memento.Editor;
import more.exercises.memento.History;

public class Main {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        editor.setContent("First text");
        history.push(editor.createState());

        editor.setContent("Second text");
        history.push(editor.createState());
        System.out.println(editor.getContent());

        editor.restoreState(history.pop());
        System.out.println(editor.getContent());
    }
}
