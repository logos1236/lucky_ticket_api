package ru.armishev.lucky_ticket_api.builders;

import ru.armishev.lucky_ticket_api.ticket.Ticket;

public interface ITicketBuilder {
    Ticket build();

    ITicketBuilder setTicketInfo(long number, int countNumbers);

}
