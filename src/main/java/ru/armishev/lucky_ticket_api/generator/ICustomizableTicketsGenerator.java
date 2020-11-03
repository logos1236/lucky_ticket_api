package ru.armishev.lucky_ticket_api.generator;

import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.Iterator;

public interface ICustomizableTicketsGenerator extends Iterator<Lucky> {
    void setCountNumbers(int countNumbers);

    void drop();
}
