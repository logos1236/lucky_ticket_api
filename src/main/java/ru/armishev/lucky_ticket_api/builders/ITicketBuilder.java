package ru.armishev.lucky_ticket_api.builders;

import ru.armishev.lucky_ticket_api.Ticket;

public interface ITicketBuilder {
    public Ticket build();

    public ITicketBuilder setTicketInfo(long number, int count_numbers);

}
