package co.bog.felaverde.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when a reservation cannot be found by its identifier.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReservationNotFoundException extends ReservationBusinessException {

    public ReservationNotFoundException(Long id) {
        super("Reservation not found with id %d".formatted(id));
    }
}
