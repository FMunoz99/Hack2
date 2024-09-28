package dbp.hackathon.Qr;

import com.fasterxml.jackson.databind.JsonNode;
import dbp.hackathon.Email.EmailService;
import dbp.hackathon.Ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class QrEventListener {

    final private EmailService emailService;

    @Autowired
    public QrEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    @Async
    public void onQrCreated(QrCreatedEvent event) {
        Ticket ticket = event.getTicket();
        JsonNode data = event.getResponseBody();
        emailService.sendEmail(ticket.getQr(),"QR Funcion", "Hola "+", este es el QR para la función del día: " + data.get("roomUrl").asText());
    }
}
