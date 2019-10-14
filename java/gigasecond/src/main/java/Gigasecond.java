import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final static int GIGASECOND = 1_000_000_000;
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        localDateTime = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() { return localDateTime; }
}
