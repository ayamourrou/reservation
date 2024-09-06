package com.example.demo.Services;


import com.example.demo.Models.Vehicule;
import com.example.demo.Repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    // Méthode pour vérifier la disponibilité d'un véhicule
    public boolean estVehiculeDisponible(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElse(null);
        return vehicule != null && vehicule.estDisponible();
    }
}
