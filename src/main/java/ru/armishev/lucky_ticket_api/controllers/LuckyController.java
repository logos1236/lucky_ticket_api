package ru.armishev.lucky_ticket_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.armishev.lucky_ticket_api.model.ILuckyModel;
import ru.armishev.lucky_ticket_api.ticket.Filter;
import ru.armishev.lucky_ticket_api.ticket.Lucky;
import ru.armishev.lucky_ticket_api.model.LuckyModel;
import ru.armishev.lucky_ticket_api.viwers.LuckyViewer;

import java.util.List;

@Controller
@RequestMapping(value="/6-digits/")
public class LuckyController {
    @Autowired
    @Qualifier("LuckyModel")
    ILuckyModel model;

    @GetMapping("lucky/")
    @ResponseBody
    public String getSimpleList() {
        List<Lucky> list = model.getList(6, Filter.LUCKY);
        LuckyViewer viewer = new LuckyViewer(list);

        return viewer.printList();
    }
}
