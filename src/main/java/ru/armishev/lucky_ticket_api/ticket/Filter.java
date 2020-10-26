package ru.armishev.lucky_ticket_api.ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public enum Filter {
    LUCKY, EVEN_LUCKY, THIRD_LUCKY, FIVE_LUCKY, SEVEN_LUCKY;

    private static Map<Filter,Predicate<Lucky>> filters = new HashMap();

    static {
        filters.put(LUCKY, (ticket) -> {
            return ticket.isLucky();
        });
        filters.put(EVEN_LUCKY, (ticket) -> {
            return ticket.isEvenLucky();
        });
        filters.put(THIRD_LUCKY, (ticket) -> {
            return ticket.isThirdLucky();
        });
        filters.put(FIVE_LUCKY, (ticket) -> {
            Ticket tmp_ticket = (Ticket)ticket;
            return ticket.isLucky() && (tmp_ticket.getNumber() % 5 == 0);
        });
        filters.put(SEVEN_LUCKY, (ticket) -> {
            Ticket tmp_ticket = (Ticket)ticket;
            return ticket.isLucky() && (tmp_ticket.getNumber() % 7 == 0);
        });
    }

    public static Predicate<Lucky> getFilter(Filter filter_name) {
        if (filters.containsKey(filter_name)) {
            return filters.get(filter_name);
        } else {
            throw new IllegalArgumentException("Передано неправильное имя фильтра");
        }
    }

}
