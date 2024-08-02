package com.codewithmosh.decorator;

public class SetErrorDecorator implements Component {

    private Component component;

    public SetErrorDecorator(Component component) {
        this.component = component;
    }
    @Override
    public String render() {
        return String.format("%s %s", component.render(), "[Error]");
    }
}
