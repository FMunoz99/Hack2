package dbp.hackathon.Email;

import dbp.hackathon.Ticket.Ticket;

public class SendConfirmedEmailEvent {

    private Ticket ticket;

    public SendConfirmedEmailEvent(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}