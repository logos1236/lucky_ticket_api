package ru.armishev.lucky_ticket_api.viwers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.List;
import java.util.stream.Collectors;

public class LuckyViewer {
    private final List<Lucky> list;

    public LuckyViewer(List<Lucky> list) {
        this.list = list;
    }

    private static List<String> buildListNumbers(List<Lucky> list) {
        return list.stream().map(lucky -> lucky.toString()).collect(Collectors.toList());
    }

    private static String buildJson(List<String> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            json = "";
        }

        return json;
    }

    public String printLuckyListJson() {
        List<String> numbersList = buildListNumbers(this.list);
        return buildJson(numbersList);
    }
}
