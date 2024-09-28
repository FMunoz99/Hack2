package dbp.hackathon.Qr;

import com.fasterxml.jackson.databind.JsonNode;
import dbp.hackathon.Ticket.Ticket;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class QrCreatedEvent extends ApplicationEvent {

    private final Ticket ticket;
    private final JsonNode responseBody;

    public QrCreatedEvent(Object source, Ticket ticket, JsonNode responseBody) {
        super(source);
        this.ticket = ticket;
        this.responseBody = responseBody;
    }
}
