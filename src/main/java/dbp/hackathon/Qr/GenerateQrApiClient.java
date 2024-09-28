package dbp.hackathon.Qr;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbp.hackathon.Ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GenerateQrApiClient {

    final private ApplicationEventPublisher eventPublisher;

    @Autowired
    public GenerateQrApiClient(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    private String qrApi;

    final private HttpClient httpClient = HttpClient.newHttpClient();

    @Async
    public void createQr(Ticket ticket) throws IOException, InterruptedException {

        //PONER ESTO EN EL LI K D TICKXET
        http://api.qrserver.com/v1/create-qr-code/?data=HelloWorld!&size=100x100


        https://api.qrserver.com/v1/create-qr-code/?size=150x150&data= GET ID

        var request = HttpRequest.newBuilder(URI.create(" https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=getTicked(id)"))
                .header("Authorization", "Bearer " + qrApi)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(data)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            var responseBody = new ObjectMapper().readTree(response.body());
            System.out.println("QR generado correctamente");
            eventPublisher.publishEvent(new QrCreatedEvent(this, ticket, responseBody));
        } else {
            throw new RuntimeException("Error generando QR");
        }
    }
}
