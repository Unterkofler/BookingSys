package writeside;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import writeside.event.Event;


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

    public Boolean publishRoomAdded(Event event){
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/roomAdded")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), Event.class)
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
                .body(Mono.just(event), Event.class)
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
                .body(Mono.just(event), Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
