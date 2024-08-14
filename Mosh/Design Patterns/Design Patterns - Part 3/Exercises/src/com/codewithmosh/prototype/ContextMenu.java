package com.codewithmosh.prototype;

public class ContextMenu {
    private Timeline timeline;

    public ContextMenu(Timeline timeline) {
        this.timeline = timeline;
    }

    public void duplicate(Component component) {
        var duplicate = component.clone();
        timeline.add(duplicate);
    }
}
