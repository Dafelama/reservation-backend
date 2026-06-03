package co.bog.felaverde.reservation.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import co.bog.felaverde.reservation.entity.ReservationEntity;
import co.bog.felaverde.reservation.entity.ReservationStatus;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    /**
     * Checks whether an active reservation already exists for the given slot.
     *
     * @param date reservation date
     * @param time reservation time
     * @param status reservation status
     * @return {@code true} when a matching reservation exists
     */
    boolean existsByDateAndTimeAndStatus(LocalDate date, LocalTime time, ReservationStatus status);
    

}
