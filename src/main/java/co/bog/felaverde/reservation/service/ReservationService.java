package co.bog.felaverde.reservation.service;

import java.util.List;

import co.bog.felaverde.reservation.dto.request.CreateReservationRequest;
import co.bog.felaverde.reservation.dto.response.ReservationResponse;
import co.bog.felaverde.reservation.exception.ReservationAlreadyCancelledException;
import co.bog.felaverde.reservation.exception.ReservationNotFoundException;
import co.bog.felaverde.reservation.exception.SlotUnavailableException;

/**
 * Reservation business operations.
 */
public interface ReservationService {

    /**
     * Creates a reservation if the requested slot is available.
     *
     * @param request reservation input data
     * @return the created reservation view
     * @throws SlotUnavailableException when the slot is already booked
     */
    ReservationResponse createReservation(CreateReservationRequest request);

    /**
     * Cancels an active reservation.
     *
     * @param id reservation identifier
     * @return the cancelled reservation view
     * @throws ReservationNotFoundException when no reservation exists for the id
     * @throws ReservationAlreadyCancelledException when the reservation is already cancelled
     */
    ReservationResponse cancelReservation(Long id);

    /**
     * Returns all reservations.
     *
     * @return list of reservation views
     */
    List<ReservationResponse> getReservations();
}
