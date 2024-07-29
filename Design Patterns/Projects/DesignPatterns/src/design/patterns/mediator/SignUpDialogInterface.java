package design.patterns.mediator;

public class SignUpDialogInterface {

    private TextBox nameTextBox = new TextBox();
    private TextBox passwordTextBox = new TextBox();
    private CheckBox checkBox = new CheckBox();
    private Button signUpButton = new Button();

    public SignUpDialogInterface() {
        nameTextBox.addEventHandler(this::enableSignUpButton);
        passwordTextBox.addEventHandler(this::enableSignUpButton);
        checkBox.addEventHandler(this::enableSignUpButton);
    }

    private void enableSignUpButton() {
        signUpButton.setEnabled(isFormValid());
    }

    private boolean isFormValid() {
        return (!nameTextBox.isEmpty() && !passwordTextBox.isEmpty() && checkBox.isChecked());
    }

    public void simulateUserBehaviour() {
        System.out.println("The sign up button is enabled: " + signUpButton.isEnabled());
        this.nameTextBox.setText("Eli");
        this.passwordTextBox.setText("2000");
        this.checkBox.setChecked(true);
        System.out.println("The sign up button is enabled: " + signUpButton.isEnabled());
    }
}
