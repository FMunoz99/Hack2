package dbp.hackathon.Email;

import dbp.hackathon.Ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailEventListener {

    @Autowired
    private EmailService emailService; // El servicio que envía el correo

    @EventListener
    public void handleSendConfirmedEmailEvent(SendConfirmedEmailEvent event) {
        Ticket ticket = event.getTicket();
        // Envía el correo utilizando tu servicio de email
        emailService.sendEmail(ticket);
    }
}