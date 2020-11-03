package ru.armishev.lucky_ticket_api.generator;

import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.Iterator;

public interface ICustomizableTicketsGenerator extends Iterator<Lucky> {
    void setCount_numbers(int count_numbers);

    void drop();
}
