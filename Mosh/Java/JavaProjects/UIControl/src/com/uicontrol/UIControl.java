package com.uicontrol;

// Initialize class to control the instance state
public abstract class UIControl {

    // Initialize the class fields
    private boolean isEnabled = true;

    // Initialize the class constructor method
    public UIControl() {
    }

    // Initialize method that enables the instance
    public void enableInstance() {
        isEnabled = true;
    }

    // Initialize method that disables the instance
    public void disableInstance() {
        isEnabled = false;
    }

    // Initialize getter method for the isEnabled field
    public boolean getIsEnabled() {
        return isEnabled;
    }

    // Initialize method to render the instance
    public abstract void render();
}
