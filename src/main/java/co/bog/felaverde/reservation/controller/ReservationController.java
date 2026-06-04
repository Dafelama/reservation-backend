package co.bog.felaverde.reservation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.bog.felaverde.reservation.dto.request.CreateReservationRequest;
import co.bog.felaverde.reservation.dto.response.ReservationResponse;
import co.bog.felaverde.reservation.service.ReservationService;
import jakarta.validation.Valid;

/**
 * REST endpoints for reservation management.
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * Creates the controller with its service dependency.
     *
     * @param reservationService reservation business service
     */
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Creates a new reservation.
     *
     * @param request validated reservation input
     * @return the created reservation with {@code 201 Created}
     */
    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(
            @Valid @RequestBody CreateReservationRequest request) {
        var response = reservationService.createReservation(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Cancels an existing reservation.
     *
     * @param id reservation identifier
     * @return the cancelled reservation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationResponse> cancelReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.cancelReservation(id));
    }

    @GetMapping
    public List<ReservationResponse> getReservations() {
        return reservationService.getReservations();
    }
}
