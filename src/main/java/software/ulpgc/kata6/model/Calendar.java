package software.ulpgc.kata6.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import static java.time.DayOfWeek.*;

public class Calendar {
    public Iterable<LocalDate> from(LocalDate localDate){ return () -> createIterFrom(localDate);}

    private Iterator<LocalDate> createIterFrom(LocalDate localDate) {
        return new Iterator<LocalDate>() {
            private LocalDate currentDate = localDate.minusDays(1);

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                while (true) {
                    currentDate.plusDays(1);
                    if (isWorkingDay(currentDate)) return currentDate;
                }
            }
        };
    }

    private boolean isWorkingDay(LocalDate currentDate) {
        return workingDaysOfWeek.contains(currentDate.getDayOfWeek());
    }

    private static final Set<DayOfWeek> workingDaysOfWeek = Set.of(
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    );
}
