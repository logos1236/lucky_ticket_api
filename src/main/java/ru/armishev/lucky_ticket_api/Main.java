package ru.armishev.lucky_ticket_api;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.armishev");
        Supplier lucky_count = context.getBean("AppLuckyCount", Supplier.class);
        List<Lucky> luckyList = (List<Lucky>)lucky_count.get();

        luckyList.forEach(ticket->{
            System.out.println(ticket);
        });

        System.out.println(luckyList.size());
    }
}
