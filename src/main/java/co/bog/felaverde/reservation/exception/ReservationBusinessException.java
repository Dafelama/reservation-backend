package co.bog.felaverde.reservation.exception;

/**
 * Base type for reservation domain rule violations.
 */
public abstract class ReservationBusinessException extends RuntimeException {

    protected ReservationBusinessException(String message) {
        super(message);
    }
}
