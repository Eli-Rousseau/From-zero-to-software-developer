package design.patterns.mediator;

public class TextBox extends UIControler {

    private String text;

    public void setText(String text) {
        this.text = text;
        notifyEventHandler();
    }

    public String getText() {
        return text;
    }

    public boolean isEmpty() {
        return (text == null || text.equals(""));
    }
}
