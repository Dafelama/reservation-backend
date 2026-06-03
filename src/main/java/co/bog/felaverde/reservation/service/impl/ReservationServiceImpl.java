package co.bog.felaverde.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bog.felaverde.reservation.dto.request.CreateReservationRequest;
import co.bog.felaverde.reservation.dto.response.ReservationResponse;
import co.bog.felaverde.reservation.entity.ReservationEntity;
import co.bog.felaverde.reservation.entity.ReservationStatus;
import co.bog.felaverde.reservation.exception.ReservationAlreadyCancelledException;
import co.bog.felaverde.reservation.exception.ReservationNotFoundException;
import co.bog.felaverde.reservation.exception.SlotUnavailableException;
import co.bog.felaverde.reservation.repository.ReservationRepository;
import co.bog.felaverde.reservation.service.ReservationService;

/**
 * Default implementation of {@link ReservationService}.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    /**
     * Creates the service with its persistence dependency.
     *
     * @param reservationRepository reservation repository
     */
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ReservationResponse createReservation(CreateReservationRequest request) {
        if (reservationRepository.existsByDateAndTimeAndStatus(
                request.date(), request.time(), ReservationStatus.ACTIVE)) {
            throw new SlotUnavailableException(request.date(), request.time());
        }

        var entity = new ReservationEntity();
        entity.setCustomerName(request.customerName());
        entity.setDate(request.date());
        entity.setTime(request.time());
        entity.setService(request.service());
        entity.setStatus(ReservationStatus.ACTIVE);

        return ReservationResponse.from(reservationRepository.save(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ReservationResponse cancelReservation(Long id) {
        var entity = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        if (entity.getStatus() == ReservationStatus.CANCELLED) {
            throw new ReservationAlreadyCancelledException(id);
        }

        entity.setStatus(ReservationStatus.CANCELLED);
        return ReservationResponse.from(reservationRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponse> getReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationResponse::from)
                .toList();
    }

    
}
