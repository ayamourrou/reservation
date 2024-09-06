package com.example.demo.Services;

import com.example.demo.Models.Reservation;
import com.example.demo.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long reservationId) {
        boolean exists = reservationRepository.existsById(reservationId);
        if (!exists) {
            throw new IllegalStateException("Reservation with id " + reservationId + " does not exist");
        }
        reservationRepository.deleteById(reservationId);
    }

    @Transactional
    public void updateReservation(Long reservationId, String type, Date date, String destination) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalStateException("Reservation with id " + reservationId + " does not exist"));

        if (type != null && !type.isEmpty()) {
            reservation.setType(type);
        }
        if (date != null) {
            reservation.setDate(date);
        }
        if (destination != null && !destination.isEmpty()) {
            reservation.setDestination(destination);
        }
    }
}
