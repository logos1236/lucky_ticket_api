package ru.armishev.lucky_ticket_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ILuckyController {
    @GetMapping(value="lucky/")
    @ResponseBody
    String getLuckyList(int countNumbers);

    @GetMapping(value="even_lucky/")
    @ResponseBody
    String getEvenLuckyList(int countNumbers);

    @GetMapping(value="third_lucky/")
    @ResponseBody
    String getThirdLuckyList(int countNumbers);

    @GetMapping(value="five_lucky/")
    @ResponseBody
    String getFiveLuckyList(int countNumbers);

    @GetMapping(value="seven_lucky/")
    @ResponseBody
    String getSevenLuckyList(int countNumbers);
}
