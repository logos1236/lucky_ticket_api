package ru.armishev.lucky_ticket_api.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.armishev.lucky_ticket_api.builders.TicketBuilder;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.NoSuchElementException;

@Service("Generator")
public class CustomizableTicketsGenerator implements ICustomizableTicketsGenerator {
    private int maxCount;
    private int countNumbers;
    private int current = 0;

    @Autowired
    public CustomizableTicketsGenerator(@Qualifier("CountDigitsInTicket")int countDigits) {
        if (countDigits < 2) {
            throw new IllegalArgumentException("Нужны минимум 2 цифры");
        }

        this.countNumbers = countDigits;
        this.maxCount = (int)Math.pow(10,countDigits);
    }

    public void setCountNumbers(int countNumbers) {
        this.countNumbers = countNumbers;
        this.maxCount = (int)Math.pow(10, countNumbers);
    }

    @Override
    public void drop() {
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return (current < maxCount);
    }

    @Lookup
    public TicketBuilder createTicketBuilder() {return null;}

    @Override
    public Lucky next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Выход за границы итеротора");
        }

        Lucky result = createTicketBuilder().setTicketInfo(current, countNumbers).build();
        current++;

        return result;
    }
}
