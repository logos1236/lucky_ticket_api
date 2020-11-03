package ru.armishev.lucky_ticket_api.builders;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.armishev.lucky_ticket_api.ticket.Ticket;

@Component
@Scope("prototype")
public class TicketBuilder implements ITicketBuilder {
    private int[] ticketNumber;

    /*
    Признак того, что билет уже использовался
    */
    private Boolean isUsed = false;

    @Override
    public Ticket build() {
        if (Boolean.TRUE.equals(isUsed)) {
            throw new IllegalArgumentException("Билет уже использовался");
        }

        isUsed = true;
        return new Ticket(ticketNumber);
    }

    @Override
    public TicketBuilder setTicketInfo(long number, int countNumbers) {
        this.ticketNumber = Ticket.getSupplementedTicketNumber(number, countNumbers);
        return this;
    }
}
