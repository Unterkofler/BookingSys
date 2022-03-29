package writeside.event;

import java.util.UUID;

public abstract class AbstractEvent {
    private long timeStamp = System.currentTimeMillis();
    private UUID eventID = UUID.randomUUID();

    public AbstractEvent() {
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public UUID getEventID() {
        return eventID;
    }

    public void setEventID(UUID eventID) {
        this.eventID = eventID;
    }
}
