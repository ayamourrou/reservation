package com.example.demo.Services;

import com.example.demo.Models.Deplacement;
import com.example.demo.Repositories.DeplacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeplacementService {
    private final DeplacementRepository deplacementRepository;

    @Autowired
    public DeplacementService(DeplacementRepository deplacementRepository) {
        this.deplacementRepository = deplacementRepository;
    }

    public List<Deplacement> getAllDeplacements() {
        return deplacementRepository.findAll();
    }

    public void addDeplacement(Deplacement deplacement) {
        deplacementRepository.save(deplacement);
    }

    public Deplacement getDeplacementById(Long id) {
        return deplacementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Deplacement with id " + id + " does not exist"));
    }

    public void deleteDeplacement(Long id) {
        boolean exists = deplacementRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Deplacement with id " + id + " does not exist");
        }
        deplacementRepository.deleteById(id);
    }

    @Transactional
    public void updateDeplacement(Long id, Date dateDebut, Date dateFin, String lieuDepart, String lieuArrivee, Boolean besoinNavette, Boolean repasInclus, Boolean moyenTransportPersonnel) {
        Deplacement deplacement = deplacementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Deplacement with id " + id + " does not exist"));
        if (dateDebut != null && !dateDebut.equals(deplacement.getDateDebut())) {
            deplacement.setDateDebut(dateDebut);
        }
        if (dateFin != null && !dateFin.equals(deplacement.getDateFin())) {
            deplacement.setDateFin(dateFin);
        }
        if (lieuDepart != null && !lieuDepart.isEmpty() && !lieuDepart.equals(deplacement.getLieuDepart())) {
            deplacement.setLieuDepart(lieuDepart);
        }
        if (lieuArrivee != null && !lieuArrivee.isEmpty() && !lieuArrivee.equals(deplacement.getLieuArrivee())) {
            deplacement.setLieuArrivee(lieuArrivee);
        }
        if (besoinNavette != null && !besoinNavette.equals(deplacement.getBesoinNavette())) {
            deplacement.setBesoinNavette(besoinNavette);
        }
        if (repasInclus != null && !repasInclus.equals(deplacement.getRepasInclus())) {
            deplacement.setRepasInclus(repasInclus);
        }
        if (moyenTransportPersonnel != null && !moyenTransportPersonnel.equals(deplacement.getMoyenTransportPersonnel())) {
            deplacement.setMoyenTransportPersonnel(moyenTransportPersonnel);
        }
    }
}
