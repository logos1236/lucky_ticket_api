package ru.armishev.lucky_ticket_api.ticket;

import java.util.EnumMap;
import java.util.function.Predicate;

public enum Filter {
    LUCKY, EVEN_LUCKY, THIRD_LUCKY, FIVE_LUCKY, SEVEN_LUCKY;

    private static final EnumMap<Filter,Predicate<Lucky>> filters = new EnumMap<>(Filter.class);

    static {
        filters.put(LUCKY, ticket -> ticket.isLucky());
        filters.put(EVEN_LUCKY, ticket -> ticket.isEvenLucky());
        filters.put(THIRD_LUCKY, ticket -> ticket.isThirdLucky());
        filters.put(FIVE_LUCKY, ticket -> {
            Ticket tmpTicket = (Ticket)ticket;
            return ticket.isLucky() && (tmpTicket.getNumber() % 5 == 0);
        });
        filters.put(SEVEN_LUCKY, ticket -> {
            Ticket tmpTicket = (Ticket)ticket;
            return ticket.isLucky() && (tmpTicket.getNumber() % 7 == 0);
        });
    }

    public static Predicate<Lucky> getFilter(Filter filterName) {
        if (filters.containsKey(filterName)) {
            return filters.get(filterName);
        } else {
            throw new IllegalArgumentException("Передано неправильное имя фильтра");
        }
    }

}
