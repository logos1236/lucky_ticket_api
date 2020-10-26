package ru.armishev.lucky_ticket_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.armishev.lucky_ticket_api.ticket.Filter;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.function.Predicate;

@Configuration
public class AppConfig {
    @Bean("CountDigitsInTicket")
    public static Integer getCountDigitsInTicket() {
        return 5;
    }

    @Bean("LuckyMethod")
    public static Predicate<Lucky> getLuckyMethod() {
        return Filter.getFilter(Filter.LUCKY);
    }
}
