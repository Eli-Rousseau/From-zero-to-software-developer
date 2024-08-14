package com.codewithmosh.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {
    private List<Mediator> mediators = new ArrayList<>();

    public void addMediator(Mediator mediator) {
        mediators.add(mediator);
    }

    public void notifyMediators() {
        for (Mediator mediator : mediators) {
            mediator.update();
        }
    }
}
