package sfgamedataeditor.views.main.modules.common.eventhistory;

import sfgamedataeditor.events.EventHandlerRegister;
import sfgamedataeditor.events.types.Event;

import java.util.ArrayList;
import java.util.List;

public enum EventHistory {
    INSTANCE;

    private List<Event> events = new ArrayList<>();
    private int currentEventIndex = -1;

    public boolean addEventToHistory(Event event) {
        boolean isSuccess = this.events.add(event);
        currentEventIndex++;
        return isSuccess;
    }

    public void undo() {
        currentEventIndex--;
        fireCurrentEvent();
    }

    public void redo() {
        currentEventIndex++;
        fireCurrentEvent();
    }

    private void fireCurrentEvent() {
        Event event = events.get(currentEventIndex);
        EventHandlerRegister.INSTANCE.fireEventSilently(event);
    }

    public boolean isRedoPossible() {
        int nextIndex = currentEventIndex + 1;
        if (nextIndex > events.size() - 1) {
            return false;
        }

        return events.get(nextIndex) != null;
    }

    public boolean isUndoPossible() {
        int previousIndex = currentEventIndex - 1;
        if (previousIndex < 0) {
            return false;
        }

        return events.get(previousIndex) != null;
    }
}
