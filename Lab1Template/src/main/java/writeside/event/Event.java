package writeside.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = RoomCreated.class, name = "roomCreated"),
        @JsonSubTypes.Type(value = BookingCreated.class, name = "bookingCreated"),
        @JsonSubTypes.Type(value = BookingCanceled.class, name = "bookingCanceled"),
        @JsonSubTypes.Type(value = RoomBookingCreated.class, name = "roomBookingCreated"),
        @JsonSubTypes.Type(value = RoomBookingCanceled.class, name = "roomBookingCanceled")
})

public abstract class Event {
    private long timeStamp = System.currentTimeMillis();
    private UUID eventID = UUID.randomUUID();

    public Event() {
    }
}
