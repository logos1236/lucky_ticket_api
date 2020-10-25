package ru.armishev.lucky_ticket_api.model;

import org.springframework.stereotype.Service;
import ru.armishev.lucky_ticket_api.AppLuckyCount;
import ru.armishev.lucky_ticket_api.Lucky;
import ru.armishev.lucky_ticket_api.builders.LuckyCountBuilder;

import java.util.ArrayList;
import java.util.List;

@Service("LuckyModel")
public class LuckyModel {
    public List<Lucky> getList() {
        LuckyCountBuilder luckyCountBuilder = new LuckyCountBuilder();
        AppLuckyCount appLuckyCount = luckyCountBuilder.buildIterator(6).
                buildMethod((ticket) -> {
                    return ticket.isThirdLucky();
                }).build();

        return appLuckyCount.get();
    }
}
