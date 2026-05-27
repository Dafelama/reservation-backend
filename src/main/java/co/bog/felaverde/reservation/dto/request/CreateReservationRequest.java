package co.bog.felaverde.reservation.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Input data required to create a new reservation.
 */
public record CreateReservationRequest(
        String customerName,
        LocalDate date,
        LocalTime time,
        String service
) {
}
