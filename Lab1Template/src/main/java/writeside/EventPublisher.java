package writeside;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import writeside.event.*;


@Component
public class EventPublisher {

    private final WebClient localApiClient = WebClient.create("http://localhost:8080");

    public EventPublisher() {
    }

    public Boolean publishEvent(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishRoomCreated(Event event){
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/roomCreated")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), RoomCreated.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean bookingCreated(Event event){
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/bookingCreated/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), BookingCreated.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishBookingCanceled(Event event){
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/bookingCanceled")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), BookingCanceled.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishRoomBookingCreated(Event event){
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/roomBookingCreated")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), RoomBookingCreated.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishRoomBookingCanceled(Event event){
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/roomBookingCanceled/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), RoomBookingCanceled.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
