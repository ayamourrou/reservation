package com.example.demo.Models;

import jakarta.persistence.*;

@Table
@Entity
public class Hotel {
    @Id
    @SequenceGenerator(
            name = "hotel_sequence",
            sequenceName = "hotel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_sequence")
    private Long id;

    private String name;
    private String address;
    private int numberOfRooms;
    private double pricePerNight;

    // Constructeurs
    public Hotel() {}

    public Hotel(Long id, String name, String address, int numberOfRooms, double pricePerNight) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.pricePerNight = pricePerNight;
    }

    public Hotel(String name, String address, int numberOfRooms, double pricePerNight) {
        this.name = name;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.pricePerNight = pricePerNight;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
