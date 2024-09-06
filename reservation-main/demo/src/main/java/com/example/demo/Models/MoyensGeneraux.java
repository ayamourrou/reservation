package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class MoyensGeneraux {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String motDePasse;
    private List<Reservation> reservations;

    public MoyensGeneraux(int id, String nom, String prenom, String email, String role, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
        this.motDePasse = motDePasse;
        this.reservations = new ArrayList<>();
    }

    public MoyensGeneraux() {

    }

    // Recevoir une notification d'un employé étranger et commencer les réservations
    public void recevoirNotification(Employe employe, Date dateArrivee, Date dateDepart) {
        System.out.println("Notification reçue pour " + employe.getName() + ". Dates: arrivée " + dateArrivee + ", départ " + dateDepart);
        // Commencer à faire les réservations
        validerReservation(new Reservation("Navette aéroport", employe.getDeplacement().getDestination()));
        validerReservation(new Reservation("Hotel", employe.getDeplacement().getDestination()));
        validerReservation(new Reservation("Repas", employe.getDeplacement().getDestination()));
    }

    // Valider une réservation et l'ajouter à la liste
    public void validerReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Réservation validée : " + reservation.getType() + " pour la destination " + reservation.getDestination());
    }

    // Consulter les réservations
    public List<Reservation> consulterReservations() {
        return reservations;
    }
}
