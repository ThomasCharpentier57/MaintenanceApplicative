package mycalendar.event;

import java.util.Objects;

public class EventId {
    private int id;
    public EventId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EventId eventId = (EventId) o;
        return id == eventId.id;
    }

}
