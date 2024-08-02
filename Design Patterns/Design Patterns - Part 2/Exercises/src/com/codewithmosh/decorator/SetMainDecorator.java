package com.codewithmosh.decorator;

public class SetMainDecorator implements Component {

    private Component component;

    public SetMainDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String render() {
        return String.format("%s %s", component.render(), "[Main]");
    }
}
