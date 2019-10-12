import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final static int GIGASECOND = 1000000000;
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        localDateTime = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
        localDateTime = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() { return localDateTime; }
}
