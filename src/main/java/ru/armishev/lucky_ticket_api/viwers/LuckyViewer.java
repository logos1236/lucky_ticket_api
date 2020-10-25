package ru.armishev.lucky_ticket_api.viwers;

import ru.armishev.lucky_ticket_api.Lucky;
import ru.armishev.lucky_ticket_api.Ticket;

import java.util.List;

public class LuckyViewer {
    List<Lucky> list;

    public LuckyViewer(List<Lucky> list) {
        this.list = list;
    }

    public String printList() {
        StringBuilder sb = new StringBuilder();

        this.list.forEach(lucky -> {
            Ticket t = (Ticket) lucky;
            sb.append(t);
        });

        return sb.toString();
    }
}
