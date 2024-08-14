package com.codewithmosh.mediator;

public class EnableButtonMediator implements Mediator {
    private TextBox name;
    private TextBox password;
    private CheckBox terms;
    private Button button;

    public EnableButtonMediator(TextBox name, TextBox password, CheckBox terms, Button button) {
        this.name = name;
        this.name.addMediator(this);
        this.password = password;
        this.password.addMediator(this);
        this.terms = terms;
        this.terms.addMediator(this);
        this.button = button;
        this.button.addMediator(this);
    }

    @Override
    public void update() {
        if (isFilled()) {
            button.setEnabled(true);
        }
        else {
            button.setEnabled(false);
        }
    }

    public boolean isFilled() {
        return name.getContent() != null && password.getContent() != null && terms.isChecked();
    }
}
