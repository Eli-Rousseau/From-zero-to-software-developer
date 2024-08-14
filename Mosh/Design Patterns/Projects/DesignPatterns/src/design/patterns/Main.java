package design.patterns;

import design.patterns.mediator.SignUpDialogInterface;

public class Main {
    public static void main(String[] args) {
        var guiInterface = new SignUpDialogInterface();
        guiInterface.simulateUserBehaviour();
    }
}
