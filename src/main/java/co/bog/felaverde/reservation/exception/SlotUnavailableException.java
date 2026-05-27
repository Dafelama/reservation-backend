package co.bog.felaverde.reservation.exception;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Thrown when attempting to book a date and time that already has an active reservation.
 */
public class SlotUnavailableException extends ReservationBusinessException {

    public SlotUnavailableException(LocalDate date, LocalTime time) {
        super("No active reservation slot available for date %s and time %s".formatted(date, time));
    }
}
