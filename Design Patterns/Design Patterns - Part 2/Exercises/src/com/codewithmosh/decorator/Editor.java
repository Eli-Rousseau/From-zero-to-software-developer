package com.codewithmosh.decorator;

public class Editor {
    public void openProject(String path) {
        Component[] artefacts = {
                new Artefact("Main"),
                new Artefact("Demo"),
                new Artefact("EmailClient"),
                new Artefact("EmailProvider"),
        };

        artefacts[0] = new SetErrorDecorator(new SetMainDecorator(artefacts[0]));
        artefacts[2] = new SetErrorDecorator(artefacts[2]);

        for (var artefact : artefacts)
            System.out.println(artefact.render());
    }
}
