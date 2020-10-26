package ru.armishev.lucky_ticket_api.model;

import org.springframework.stereotype.Service;
import ru.armishev.lucky_ticket_api.AppLuckyCount;
import ru.armishev.lucky_ticket_api.ticket.Filter;
import ru.armishev.lucky_ticket_api.ticket.Lucky;
import ru.armishev.lucky_ticket_api.builders.LuckyCountBuilder;

import java.util.List;

@Service("LuckyModel")
public class LuckyModel implements ILuckyModel {
    public List<Lucky> getList(int count_numbers, Filter filter_name) {
        LuckyCountBuilder luckyCountBuilder = new LuckyCountBuilder();
        AppLuckyCount appLuckyCount = luckyCountBuilder
                .buildIterator(count_numbers)
                .buildMethod(Filter.getFilter(filter_name))
                .build();

        return appLuckyCount.get();
    }
}
