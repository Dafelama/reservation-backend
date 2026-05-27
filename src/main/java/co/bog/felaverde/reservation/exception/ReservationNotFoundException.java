package co.bog.felaverde.reservation.exception;

/**
 * Thrown when a reservation cannot be found by its identifier.
 */
public class ReservationNotFoundException extends ReservationBusinessException {

    public ReservationNotFoundException(Long id) {
        super("Reservation not found with id %d".formatted(id));
    }
}
