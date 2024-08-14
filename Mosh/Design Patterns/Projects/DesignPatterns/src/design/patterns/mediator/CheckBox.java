package design.patterns.mediator;

public class CheckBox extends UIControler {

    private boolean isChecked = false;

    public void setChecked(boolean checked) {
        isChecked = checked;
        notifyEventHandler();
    }

    public boolean isChecked() {
        return isChecked;
    }
}
