package ru.armishev.lucky_ticket_api.builders;

import ru.armishev.lucky_ticket_api.AppLuckyCount;
import ru.armishev.lucky_ticket_api.Lucky;
import ru.armishev.lucky_ticket_api.Ticket;

import java.util.function.Predicate;

public interface ILuckyCountBuilder {
    public AppLuckyCount build();

    public ILuckyCountBuilder buildIterator(int count_numbers);
    public ILuckyCountBuilder buildMethod(Predicate<Lucky> method);
}
