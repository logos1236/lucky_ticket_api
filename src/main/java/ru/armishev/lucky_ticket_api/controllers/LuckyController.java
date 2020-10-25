package ru.armishev.lucky_ticket_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.armishev.lucky_ticket_api.Lucky;
import ru.armishev.lucky_ticket_api.model.LuckyModel;
import ru.armishev.lucky_ticket_api.viwers.LuckyViewer;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/ticket")
public class LuckyController {
    @Autowired
    @Qualifier("LuckyModel")
    LuckyModel model;

    @GetMapping("/simple/")
    @ResponseBody
    public String getSimpleList() {
        List<Lucky> list = model.getList();
        LuckyViewer viewer = new LuckyViewer(list);

        return viewer.printList();
    }
}
