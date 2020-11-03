package ru.armishev.lucky_ticket_api.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.armishev.lucky_ticket_api.builders.TicketBuilder;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

@Service("Generator")
public class CustomizableTicketsGenerator implements ICustomizableTicketsGenerator {
    private int MAX_COUNT;
    private int count_numbers;
    private int current = 0;

    @Autowired
    public CustomizableTicketsGenerator(@Qualifier("CountDigitsInTicket")int count_digits) throws IllegalArgumentException {
        if (count_digits < 2) {
            throw new IllegalArgumentException("Нужны минимум 2 цифры");
        }

        this.count_numbers = count_digits;
        this.MAX_COUNT = (int)Math.pow(10,count_digits);
    }

    public void setCount_numbers(int count_numbers) {
        this.count_numbers = count_numbers;
        this.MAX_COUNT = (int)Math.pow(10,count_numbers);
    }

    @Override
    public void drop() {
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return (current < MAX_COUNT);
    }

    @Lookup
    public TicketBuilder createTicketBuilder() {return null;}

    @Override
    public Lucky next() {
        Lucky result = createTicketBuilder().setTicketInfo(current, count_numbers).build();
        current++;

        return result;
    }
}
