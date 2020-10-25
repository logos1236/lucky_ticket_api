package ru.armishev.lucky_ticket_api.builders;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ru.armishev.lucky_ticket_api.AppLuckyCount;
import ru.armishev.lucky_ticket_api.Lucky;
import ru.armishev.lucky_ticket_api.generator.CustomizableTicketsGenerator;

import java.util.Iterator;
import java.util.function.Predicate;

public class LuckyCountBuilder implements ILuckyCountBuilder {
    private CustomizableTicketsGenerator iterator;
    private Predicate<Lucky> method;
    private ApplicationContext context;

    @Override
    public AppLuckyCount build() {
        AppLuckyCount appLuckyCount = new AppLuckyCount();
        appLuckyCount.setIterator(iterator);
        appLuckyCount.setMethod(method);

        return appLuckyCount;
    }

    @Override
    public ILuckyCountBuilder buildIterator(int count_numbers) {
        this.iterator = new CustomizableTicketsGenerator(count_numbers);

        return this;
    }

    @Override
    public ILuckyCountBuilder buildMethod(Predicate<Lucky> method) {
        this.method = method;

        return this;
    }
}
