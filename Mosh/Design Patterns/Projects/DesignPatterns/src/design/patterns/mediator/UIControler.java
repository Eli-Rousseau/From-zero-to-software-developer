package design.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControler {

    private List<EventHandler> eventHandlers = new ArrayList<>();

    public void addEventHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    public void notifyEventHandler() {
        for (EventHandler eventHandler : eventHandlers) {
            eventHandler.handle();
        }
    }
}
