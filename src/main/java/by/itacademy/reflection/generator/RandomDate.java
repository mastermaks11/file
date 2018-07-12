package by.itacademy.reflection.generator;


import java.time.LocalDate;


/**
 * Created by user on 30.06.2018.
 */
public class RandomDate {


    public static LocalDate RandomDateOfBirth()

    {

        int year = randBetween(1900, 2010);

        int day = randBetween(1, 28);

        int months = randBetween(1, 12);

        LocalDate date = LocalDate.of(year, months, day);

        return date;

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}

