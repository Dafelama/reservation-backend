package co.bog.felaverde.reservation.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import co.bog.felaverde.reservation.entity.ReservationEntity;
import co.bog.felaverde.reservation.entity.ReservationStatus;

/**
 * API view of a reservation.
 */
public record ReservationResponse(
        Long id,
        String customerName,
        LocalDate date,
        LocalTime time,
        String service,
        ReservationStatus status
) {

    /**
     * Maps a persisted reservation to its API representation.
     *
     * @param entity reservation entity
     * @return response DTO
     */
    public static ReservationResponse from(ReservationEntity entity) {
        return new ReservationResponse(
                entity.getId(),
                entity.getCustomerName(),
                entity.getDate(),
                entity.getTime(),
                entity.getService(),
                entity.getStatus()
        );
    }
}
