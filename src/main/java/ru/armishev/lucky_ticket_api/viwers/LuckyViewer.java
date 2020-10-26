package ru.armishev.lucky_ticket_api.viwers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.armishev.lucky_ticket_api.ticket.Lucky;
import ru.armishev.lucky_ticket_api.ticket.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class LuckyViewer {
    private List<Lucky> list;

    public LuckyViewer(List<Lucky> list) {
        this.list = list;
    }

    private static List<Long> buildListNumbers(List<Lucky> list) {
        List<Long> list_numbers = list.stream().map(lucky -> {
            Ticket tnm_ticket = (Ticket)lucky;
            return tnm_ticket.getNumber();
        }).collect(Collectors.toList());

        return list_numbers;
    }

    private static String buildJson(List<Long> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String printLuckyListJson() {
        List<Long> numbers_list = buildListNumbers(this.list);
        String json = buildJson(numbers_list);

        return json;
    }
}
