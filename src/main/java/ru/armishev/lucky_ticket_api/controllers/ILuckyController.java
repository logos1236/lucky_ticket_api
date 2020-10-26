package ru.armishev.lucky_ticket_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ILuckyController {
    @GetMapping(value="lucky/")
    @ResponseBody
    String getLuckyList(int count_numbers);

    @GetMapping(value="even_lucky/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    String getEvenLuckyList(int count_numbers);

    @GetMapping(value="third_lucky/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    String getThirdLuckyList(int count_numbers);

    @GetMapping(value="five_lucky/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    String getFiveLuckyList(int count_numbers);

    @GetMapping(value="seven_lucky/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    String getSevenLuckyList(int count_numbers);
}
