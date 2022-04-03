package eventside.publisher;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import writeside.event.Event;
import writeside.event.RoomCreated;

@Component
public class PublisherToRead implements Publisher{

    private final WebClient localApiClient = WebClient.create("http://localhost:8082");

    public PublisherToRead() {
    }

    @Override
    public Boolean roomCreated(Event event) {
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

    @Override
    public Boolean bookingCreated(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/bookingCreated")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    @Override
    public Boolean publishBookingCanceled(Event event) {
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

    @Override
    public Boolean roomBookingCreated(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/roomBookingCreated")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    @Override
    public Boolean roomBookingCanceled(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/event/roomBookingCanceled")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
