package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employe")
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String lastname;
	private int age;
	private String email;
	private String nationalite;
	private String departement;
	private String username;
	private String password;
	private String role;

	@ManyToOne
	@JoinColumn(name = "deplacement_id")
	private Deplacement deplacement;

	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservation> reservations = new ArrayList<>();


	public Employe(String name, String lastname, int age, String email, String nationalite, String departement, String username, String password, String role) {
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.nationalite = nationalite;
		this.departement = departement;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Employe(String name, String lastname, String age, String email, String marocaine, String departement, String username, String password, Deplacement deplacement, String role) {
	}
}
