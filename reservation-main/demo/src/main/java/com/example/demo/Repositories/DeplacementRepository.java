package com.example.demo.Repositories;

import com.example.demo.Models.Deplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeplacementRepository extends JpaRepository<Deplacement, Long> {
    // Additional query methods can be defined here
}
