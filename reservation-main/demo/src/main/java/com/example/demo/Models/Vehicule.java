package com.example.demo.Models;

import com.example.demo.Controllers.MoyensGeneraux;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // Type de véhicule (ex: voiture, bus)
    private String immatriculation;
    private boolean disponible;

    // Dates de réservation
    private String dateDebutReservation;
    private String dateFinReservation;

    @ManyToOne
    @JoinColumn(name = "moyens_generaux_id")
    private MoyensGeneraux moyensGeneraux;

    // Méthode pour vérifier la disponibilité du véhicule
    public boolean estDisponible() {
        return disponible && (dateDebutReservation == null || dateFinReservation == null);
    }
}
