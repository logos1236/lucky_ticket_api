package ru.armishev.lucky_ticket_api.model;

import ru.armishev.lucky_ticket_api.ticket.Filter;
import ru.armishev.lucky_ticket_api.ticket.Lucky;

import java.util.List;

public interface ILuckyModel {
    List<Lucky> getList(int count_numbers, Filter filter_name);
}
