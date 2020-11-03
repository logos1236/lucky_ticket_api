package ru.armishev.lucky_ticket_api.ticket;

import java.util.Arrays;

public class Ticket implements Lucky, ITicket {
    private final int[] number;

    public Ticket(int[] number) {
        this.number = number;
    }

    public Ticket(long number, int countNumbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Передано отрицательное число в качестве номера");
        }

        if (countNumbers < 2) {
            throw new IllegalArgumentException("Передано неправильное число в качестве количества цифр в билете");
        }

        this.number = getSupplementedTicketNumber(number, countNumbers);
    }

    public static int[] getSupplementedTicketNumber(long number, int countNumbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Передано отрицательное число в качестве номера");
        }

        if (countNumbers < 2) {
            throw new IllegalArgumentException("Передано неправильное число в качестве количества цифр в билете");
        }

        char[] numberArr = String.valueOf(number).toCharArray();
        int[] result = new int[countNumbers];
        int fillStartIndex = countNumbers - numberArr.length;

        for (int i = 0; i < numberArr.length; i++) {
            result[fillStartIndex+i] = Character.getNumericValue(numberArr[i]);
        }

        return result;
    }

    @Override
    public boolean isLucky() {
        boolean result = false;

        if (number.length%2==0) {
            result = checkIsLuckyForEven();
        } else {
            result = checkIsLuckyForNotEven();
        }

        return result;
    }

    private boolean checkIsLuckyForEven() {
        int rightSum = 0;
        int leftSum = 0;
        int middleNumberTicket = 0;

        middleNumberTicket = number.length/2;

        for(int i = 0; i < middleNumberTicket; i++) {
            leftSum += number[i];
            rightSum += number[middleNumberTicket+i];
        }

        return leftSum == rightSum;
    }

    private boolean checkIsLuckyForNotEven() {
        int rightSum = 0;
        int leftSum = 0;
        int middleNumberTicket = 0;

        middleNumberTicket = (number.length-1)/2;

        for(int i = 0; i < middleNumberTicket; i++) {
            leftSum += number[i];
            rightSum += number[middleNumberTicket+1+i];
        }

        return leftSum == rightSum;
    }

    @Override
    public boolean isEvenLucky() {
        return this.isLucky() && (this.number[this.number.length - 1] % 2 == 0);
    }

    @Override
    public boolean isThirdLucky() {
        int sumDigitsInNumber = Arrays.stream(this.number).sum();

        return this.isLucky() && (sumDigitsInNumber % 3 == 0);
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
