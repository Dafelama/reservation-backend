package co.bog.felaverde.reservation.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when attempting to book a date and time that already has an active reservation.
 */
@ResponseStatus(HttpStatus. CONFLICT)
public class SlotUnavailableException extends ReservationBusinessException {

    public SlotUnavailableException(LocalDate date, LocalTime time) {
        super("No active reservation slot available for date %s and time %s".formatted(date, time));
    }
}
