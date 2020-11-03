package ru.armishev.lucky_ticket_api.builders;

import ru.armishev.lucky_ticket_api.AppLuckyCount;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.function.Predicate;

public interface ILuckyCountBuilder {
    AppLuckyCount build();

    ILuckyCountBuilder buildIterator(int countNumbers);
    ILuckyCountBuilder buildMethod(Predicate<Lucky> method);
}
