package ru.armishev.lucky_ticket_api.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.armishev.lucky_ticket_api.AppLuckyCount;
import ru.armishev.lucky_ticket_api.builders.LuckyCountBuilder;
import ru.armishev.lucky_ticket_api.ticket.Filter;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.List;

@Service("LuckyModel")
public class LuckyModel implements ILuckyModel {
    @Autowired
    LuckyCountBuilder luckyCountBuilder;

    public List<Lucky> getList(int countNumbers, Filter filterName) {
        AppLuckyCount appLuckyCount = luckyCountBuilder
                .buildMethod(Filter.getFilter(filterName))
                .build();

        return appLuckyCount.get();
    }
}
