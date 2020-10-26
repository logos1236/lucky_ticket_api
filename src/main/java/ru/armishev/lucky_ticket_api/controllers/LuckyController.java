package ru.armishev.lucky_ticket_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.armishev.lucky_ticket_api.model.ILuckyModel;
import ru.armishev.lucky_ticket_api.ticket.Filter;
import ru.armishev.lucky_ticket_api.ticket.Lucky;
import ru.armishev.lucky_ticket_api.viwers.LuckyViewer;

import java.util.List;

@Controller
@RequestMapping(value="/{id}-digits/", produces = "application/json")
public class LuckyController implements ILuckyController {
    @Autowired
    @Qualifier("LuckyModel")
    ILuckyModel model;

    @Override
    public String getLuckyList(@PathVariable("id") int count_numbers) {
        List<Lucky> list = model.getList(count_numbers, Filter.LUCKY);
        LuckyViewer viewer = new LuckyViewer(list);

        return viewer.printLuckyListJson();
    }

    @Override
    public String getEvenLuckyList(@PathVariable("id") int count_numbers) {
        List<Lucky> list = model.getList(count_numbers, Filter.EVEN_LUCKY);
        LuckyViewer viewer = new LuckyViewer(list);

        return viewer.printLuckyListJson();
    }

    @Override
    public String getThirdLuckyList(@PathVariable("id") int count_numbers) {
        List<Lucky> list = model.getList(count_numbers, Filter.THIRD_LUCKY);
        LuckyViewer viewer = new LuckyViewer(list);

        return viewer.printLuckyListJson();
    }

    @Override
    public String getFiveLuckyList(@PathVariable("id") int count_numbers) {
        List<Lucky> list = model.getList(count_numbers, Filter.FIVE_LUCKY);
        LuckyViewer viewer = new LuckyViewer(list);

        return viewer.printLuckyListJson();
    }

    @Override
    public String getSevenLuckyList(@PathVariable("id") int count_numbers) {
        List<Lucky> list = model.getList(count_numbers, Filter.SEVEN_LUCKY);
        LuckyViewer viewer = new LuckyViewer(list);

        return viewer.printLuckyListJson();
    }
}
