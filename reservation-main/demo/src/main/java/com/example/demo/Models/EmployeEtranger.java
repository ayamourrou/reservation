package com.example.demo.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class EmployeEtranger extends Employe {

    @ManyToOne
    @JoinColumn(name = "employe_marocain_choisi_id")
    private com.example.demo.model.EmployeMarocain employeMarocainChoisi; // Employé Marocain choisi pour la visite

    public EmployeEtranger() {
        super();
    }

    public EmployeEtranger(String name, String lastname, String age, String email, String departement, String username, String password, Deplacement deplacement, String role) {
        super(name, lastname, age, email, "étranger", departement, username, password, deplacement, role);
    }

    public void annoncerDateArriveeEtDepart(Date dateArrivee, Date dateDepart, MoyensGeneraux moyensGeneraux) {
        System.out.println("Annonce des dates : arrivée " + dateArrivee + ", départ " + dateDepart);
        // Envoie une notification aux Moyens Généraux
        moyensGeneraux.recevoirNotification(this, dateArrivee, dateDepart);
        if (employeMarocainChoisi != null) {
            // Envoie une notification à l'Employé Marocain choisi
            employeMarocainChoisi.recevoirNotification(this, dateArrivee, dateDepart);
        }
    }

    public void setEmployeMarocainChoisi(EmployeMarocain employeMarocainChoisi) {
        this.employeMarocainChoisi = employeMarocainChoisi;
    }
}
