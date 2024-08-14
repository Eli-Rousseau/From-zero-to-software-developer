package com.codewithmosh.mediator;

public class Demo {
    public static void main(String[] args) {
        var name = new TextBox();
        var password = new TextBox();
        var terms = new CheckBox();
        var button = new Button();

        var mediator = new EnableButtonMediator(name, password, terms, button);
        System.out.println("The button is enabled: " + button.isEnabled());

        name.setContent("Eli");
        password.setContent("2000");
        terms.setChecked(true);
        System.out.println("The button is enabled: " + button.isEnabled());
    }
}
