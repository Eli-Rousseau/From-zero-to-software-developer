package design.patterns.mediator;

public class Button extends UIControler {

    private boolean isEnabled;

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
