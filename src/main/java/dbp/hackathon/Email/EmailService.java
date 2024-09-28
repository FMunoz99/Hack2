package dbp.hackathon.Email;

import dbp.hackathon.Ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(Ticket ticket) {
        SimpleMailMessage message = new SimpleMailMessage();

        //FALTA AGREGAR LA INFO AL CORREO
        javaMailSender.send(message);
    }
}
