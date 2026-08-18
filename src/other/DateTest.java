package other;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

public class DateTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toEpochDay());
        System.out.println(localDate.plusDays(1));
        System.out.println(localDate.getDayOfWeek());

        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        System.out.println(notBefore);

        boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
        System.out.println(isAfter);
        System.out.println(Calendar.getInstance().getTime().getTime());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(myObj);
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Calendar.getInstance().getTime().getTime());
        LocalDateTime beginningOfDay = LocalDate.now().atStartOfDay();
        System.out.println(beginningOfDay);
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);
    }

}
