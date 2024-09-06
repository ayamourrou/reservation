package com.example.demo.Services;

import com.example.demo.Models.EmployeMarocain;
import com.example.demo.Models.MoyensGeneraux;
import com.example.demo.Models.Reservation;
import com.example.demo.Repositories.EmployeMarocainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoyensGenerauxService {

    private List<MoyensGeneraux> moyensGenerauxList; // Simule la base de données pour l'instant

    @Autowired
    private EmployeMarocainRepository employeMarocainRepository;

    public MoyensGenerauxService(List<MoyensGeneraux> moyensGenerauxList) {
        this.moyensGenerauxList = moyensGenerauxList;
    }

    // Trouver un utilisateur par ID
    public Optional<MoyensGeneraux> trouverParId(int id) {
        return moyensGenerauxList.stream()
                .filter(mg -> mg.getId() == id)
                .findFirst();
    }

    // Réserver une navette d'aéroport pour un client
    public void reserverNavetteAeroport(int idClient) {
        Optional<MoyensGeneraux> mg = trouverParId(idClient);
        mg.ifPresent(moyensGeneraux -> {
            System.out.println("Navette d'aéroport réservée pour le client " + moyensGeneraux.getNom());
            // Logique pour enregistrer la réservation dans la base de données ici
        });
    }

    // Réserver une navette hôtel-travail pour un client
    public void reserverNavetteHotelTravail(int idClient) {
        Optional<MoyensGeneraux> mg = trouverParId(idClient);
        mg.ifPresent(moyensGeneraux -> {
            System.out.println("Navette hôtel-travail réservée pour le client " + moyensGeneraux.getNom());
            // Logique de réservation
        });
    }

    // Réserver des repas pour un client
    public void reserverRepas(int idClient) {
        Optional<MoyensGeneraux> mg = trouverParId(idClient);
        mg.ifPresent(moyensGeneraux -> {
            System.out.println("Repas réservés pour le client " + moyensGeneraux.getNom());
            // Logique de réservation des repas
        });
    }

    // Gérer la consultation des réservations
    public List<Reservation> consulterReservations(int idClient) {
        return trouverParId(idClient)
                .map(MoyensGeneraux::getReservations)
                .orElse(null);
    }

    // Ajouter une nouvelle réservation pour un client
    public void validerReservation(int idClient, Reservation reservation) {
        trouverParId(idClient).ifPresent(moyensGeneraux -> {
            moyensGeneraux.getReservations().add(reservation);
            System.out.println("Réservation validée : " + reservation.getType() + " pour " + moyensGeneraux.getNom());
        });
    }

    // Notifier les Moyens Généraux et les Employés Marocains lors de l'annonce des dates
    public void notifierReservation(EmployeMarocain employeMarocain, Date dateArrivee, Date dateDepart, int employeMarocainId) {
        // Méthode mise à jour pour utiliser le repository
        employeMarocainRepository.findById(employeMarocainId).ifPresent(employeMarocainFromRepo -> {
            System.out.println("Notification envoyée à l'employé marocain " + employeMarocainFromRepo.getNom() +
                    " pour l'employé étranger " + employeMarocain.getNom() +
                    " du " + dateArrivee + " au " + dateDepart);

            // Ajoutez la logique pour envoyer des notifications aux Moyens Généraux et à l'Employé Marocain
        });

        // Notifiez également tous les Moyens Généraux
        moyensGenerauxList.forEach(moyensGeneraux -> {
            System.out.println("Notification envoyée à Moyens Généraux pour l'employé étranger " +
                    employeMarocain.getNom() + " du " + dateArrivee + " au " + dateDepart);
        });
    }

    // Méthode pour récupérer un EmployeMarocain
    private EmployeMarocain getEmployeMarocain(int id) {
        return employeMarocainRepository.findById(id).orElse(null);
    }
}
