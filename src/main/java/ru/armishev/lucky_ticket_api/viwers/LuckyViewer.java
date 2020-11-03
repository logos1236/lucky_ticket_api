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

    private static List<String> buildListNumbers(List<Lucky> list) {
        List<String> list_numbers = list.stream().map(lucky -> {
            Ticket tnm_ticket = (Ticket)lucky;
            return tnm_ticket.toString();
        }).collect(Collectors.toList());

        return list_numbers;
    }

    private static String buildJson(List<String> list) {
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
        List<String> numbers_list = buildListNumbers(this.list);
        String json = buildJson(numbers_list);

        return json;
    }
}
