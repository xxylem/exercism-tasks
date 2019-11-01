import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

class Meetup {

    private LocalDate firstOfMonth;

    Meetup(int month, int year) {
        this.firstOfMonth = LocalDate.of(year, month, 1);
    }

    LocalDate day(DayOfWeek d, MeetupSchedule m) {
        switch (m) {

            case FIRST:
                return this.firstOfMonth.with(nextOrSame(d));
            case SECOND:
                return this.firstOfMonth.with(dayOfWeekInMonth(2, d));
            case THIRD:
                return this.firstOfMonth.with(dayOfWeekInMonth(3, d));
            case FOURTH:
                return this.firstOfMonth.with(dayOfWeekInMonth(4, d));
            case LAST:
                return this.firstOfMonth.with(lastInMonth(d));
            case TEENTH:
                return this.firstOfMonth.withDayOfMonth(13).with(nextOrSame(d));
            default:
                throw new IllegalArgumentException();
        }
    }
}