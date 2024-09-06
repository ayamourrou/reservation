package com.example.demo.Repositories;

import com.example.demo.Models.EmployeMarocain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeMarocainRepository extends JpaRepository<EmployeMarocain, Integer> {
    // Méthodes de recherche spécifiques peuvent être ajoutées ici si nécessaire
}
