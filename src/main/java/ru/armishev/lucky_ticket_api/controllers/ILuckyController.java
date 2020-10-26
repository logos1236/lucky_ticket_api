package ru.armishev.lucky_ticket_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ILuckyController {
    @GetMapping("lucky/")
    @ResponseBody
    String getLuckyList(int count_numbers);

    @GetMapping("even_lucky/")
    @ResponseBody
    String getEvenLuckyList(int count_numbers);

    @GetMapping("third_lucky/")
    @ResponseBody
    String getThirdLuckyList(int count_numbers);

    @GetMapping("five_lucky/")
    @ResponseBody
    String getFiveLuckyList(int count_numbers);

    @GetMapping("seven_lucky/")
    @ResponseBody
    String getSevenLuckyList(int count_numbers);
}
