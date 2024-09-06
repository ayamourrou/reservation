package com.example.demo.model;

import com.example.demo.Models.Deplacement;
import com.example.demo.Models.Employe;
import com.example.demo.Models.MoyensGeneraux;
import com.example.demo.Models.Reservation;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class EmployeMarocain extends Employe {

    public EmployeMarocain() {
        super();
    }

    public EmployeMarocain(String name, String lastname, String age, String email, String departement, String username, String password, Deplacement deplacement, String role) {
        super(name, lastname, age, email, "marocaine", departement, username, password, deplacement, role);
    }

    // Recevoir une notification d'un employé étranger
    public void recevoirNotification(Employe employe, Date dateArrivee, Date dateDepart) {
        System.out.println("Notification reçue de l'employé étranger " + employe.getName() + ". Dates: arrivée " + dateArrivee + ", départ " + dateDepart);
        // L'employé marocain peut aussi consulter les réservations associées
    }

    // L'employé peut voir les réservations validées par les Moyens Généraux
    public List<Reservation> consulterReservations(MoyensGeneraux moyensGeneraux) {
        return moyensGeneraux.consulterReservations();
    }
}
