package com.uicontrol;

// Initialize class for creating text box instances
public class TextBox extends UIControl {

    // Initialize the class fields
    private String text = "";

    // Initialize the class constructor method
    public TextBox() {
    }

    // Initialize setter method to change the text field
    public void setText(String inputText) {
        this.text = inputText;
    }

    // Initialize method to clear the value of the text field
    public void setText() {
        this.text = "";
    }

    // Initialize override for the inherited toString method
    @Override
    public String toString() {
        return text;
    }

    // Initialize override of the inherited render method
    @Override
    public void render() {
        System.out.println("Render a textBox instance");
    }
}
