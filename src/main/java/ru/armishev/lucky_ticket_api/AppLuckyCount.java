package ru.armishev.lucky_ticket_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service("AppLuckyCount")
public class AppLuckyCount implements Supplier<List<Lucky>> {
    @Autowired
    @Qualifier("Generator")
    Iterator<Lucky> iterator;

    @Autowired
    @Qualifier("LuckyMethod")
    Predicate<Lucky> method;

    public void setIterator(Iterator<Lucky> iterator) {
        this.iterator = iterator;
    }

    public void setMethod(Predicate<Lucky> method) {
        this.method = method;
    }

    @Override
    public List<Lucky> get() {
        List<Lucky> list = new ArrayList<>();

        while (iterator.hasNext()) {
            Lucky t = iterator.next();
            if (method.test(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
