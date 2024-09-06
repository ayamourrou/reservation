package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "deplacement")
public class Deplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArrivee() {
		return lieuArrivee;
	}

	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}

	public Boolean getBesoinNavette() {
		return besoinNavette;
	}

	public void setBesoinNavette(Boolean besoinNavette) {
		this.besoinNavette = besoinNavette;
	}

	public Boolean getRepasInclus() {
		return repasInclus;
	}

	public void setRepasInclus(Boolean repasInclus) {
		this.repasInclus = repasInclus;
	}

	public Boolean getMoyenTransportPersonnel() {
		return moyenTransportPersonnel;
	}

	public void setMoyenTransportPersonnel(Boolean moyenTransportPersonnel) {
		this.moyenTransportPersonnel = moyenTransportPersonnel;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	private Date dateDebut;
    private Date dateFin;
    private String lieuDepart;
    private String lieuArrivee;
    private Boolean besoinNavette;
    private Boolean repasInclus;
    private Boolean moyenTransportPersonnel;

    // Relation OneToMany avec Employe
    @OneToMany(mappedBy = "deplacement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employe> employes = new ArrayList<>();

    // Constructeurs
    public Deplacement() {
    }

    public Deplacement(Date dateDebut, Date dateFin, String lieuDepart, String lieuArrivee, Boolean besoinNavette, Boolean repasInclus, Boolean moyenTransportPersonnel) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
        this.besoinNavette = besoinNavette;
        this.repasInclus = repasInclus;
        this.moyenTransportPersonnel = moyenTransportPersonnel;
    }

    public void getDestination() {
    }
}
