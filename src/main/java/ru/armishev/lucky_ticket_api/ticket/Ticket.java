package ru.armishev.lucky_ticket_api.ticket;

import java.util.Arrays;

public class Ticket implements Lucky, ITicket {
    private int[] number;

    public Ticket(int[] number) {
        this.number = number;
    }

    public Ticket(long number, int count_numbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Передано отрицательное число в качестве номера");
        }

        if (count_numbers < 2) {
            throw new IllegalArgumentException("Передано неправильное число в качестве количества цифр в билете");
        }

        this.number = getSupplementedTicketNumber(number, count_numbers);
    }

    public static int[] getSupplementedTicketNumber(long number, int count_numbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Передано отрицательное число в качестве номера");
        }

        if (count_numbers < 2) {
            throw new IllegalArgumentException("Передано неправильное число в качестве количества цифр в билете");
        }

        char[] number_arr = String.valueOf(number).toCharArray();
        int[] result = new int[count_numbers];
        int fill_start_index = count_numbers - number_arr.length;

        for (int i = 0; i < number_arr.length; i++) {
            result[fill_start_index+i] = Character.getNumericValue(number_arr[i]);
        }

        return result;
    }

    @Override
    public boolean isLucky() {
        int right_summ = 0;
        int left_summ = 0;
        int middle_number_ticket = 0;

        if (number.length%2==0) {
            middle_number_ticket = (int)Math.ceil(number.length/2)-1;
        } else {
            middle_number_ticket = (int)Math.ceil(number.length/2);
        }

        for(int i = 0; i <= middle_number_ticket; i++) {
            left_summ += number[i];
            right_summ += number[middle_number_ticket+i];
        }

        return (left_summ == right_summ) ? true: false;
    }

    @Override
    public boolean isEvenLucky() {
        return this.isLucky() && (this.number[this.number.length-1]%2==0) ? true : false;
    }

    @Override
    public boolean isThirdLucky() {
        int summ_digits_in_number = Arrays.stream(this.number).sum();

        return this.isLucky() && (summ_digits_in_number%3==0) ? true : false;
    }

    @Override
    public String toString() {
        return Arrays.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Arrays.equals(number, ticket.number);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(number);
    }

    @Override
    public long getNumber() {
        long result = 0;

        for(int i = 0; i < number.length ; i++) {
            int multiplication = number.length - 1 - i;
            result += Math.pow(10, multiplication)*number[i];
        }

        return result;
    }
}
