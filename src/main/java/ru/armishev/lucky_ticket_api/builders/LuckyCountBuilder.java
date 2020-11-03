package ru.armishev.lucky_ticket_api.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.armishev.lucky_ticket_api.AppLuckyCount;
import ru.armishev.lucky_ticket_api.ticket.Lucky;
import ru.armishev.lucky_ticket_api.generator.CustomizableTicketsGenerator;

import java.util.function.Predicate;

@Service("LuckyCountBuilder")
public class LuckyCountBuilder implements ILuckyCountBuilder {
    @Autowired
    AppLuckyCount appLuckyCount;

    private Predicate<Lucky> method;

    @Override
    public AppLuckyCount build() {
        appLuckyCount.setMethod(method);

        return appLuckyCount;
    }

    @Override
    public ILuckyCountBuilder buildIterator(int count_numbers) {
        appLuckyCount.setCount(count_numbers);

        return this;
    }

    @Override
    public ILuckyCountBuilder buildMethod(Predicate<Lucky> method) {
        this.method = method;

        return this;
    }
}
