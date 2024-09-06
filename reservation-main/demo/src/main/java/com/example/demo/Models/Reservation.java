package com.example.demo.Models;

import com.example.demo.Controllers.MoyensGeneraux;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;  // Type de réservation (ex: Hôtel, Véhicule)
	private String dateDebut;
	private String dateFin;

	@ManyToOne
	@JoinColumn(name = "moyens_generaux_id")
	private MoyensGeneraux moyensGeneraux;

	public Reservation(String hotel, void destination) {
	}

	public Reservation() {

	}

	public void setMoyensGeneraux(com.example.demo.Models.MoyensGeneraux moyensGeneraux) {
	}
}
