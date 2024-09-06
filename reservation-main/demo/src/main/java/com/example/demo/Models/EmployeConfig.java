package com.example.demo.Models;

import com.example.demo.Repositories.DeplacementRepository;
import com.example.demo.Repositories.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

@Configuration
public class EmployeConfig {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String encodedPassword = encoder.encode("your_plain_password");

    @Bean
    CommandLineRunner commandLineRunner(EmployeRepository employeRepository, DeplacementRepository deplacementRepository) {
        return args -> {
            // Créer un objet Deplacement
            Deplacement deplacement = new Deplacement(
                    new Date(), // dateDebut
                    new Date(), // dateFin
                    "Casablanca",
                    "Paris",
                    true,
                    false,
                    true
            );
            // Sauvegarder le Deplacement
            deplacementRepository.save(deplacement);

            // Créer des objets Employe
            Employe aya = new Employe(
                    "Aya", "mourrou", "21", "aya@gmail.com", "marocaine", "it", "ayamourrou", "aya1234", deplacement,"user"
            );
            Employe mehdi = new Employe(
                    "mehdi", "tazi", "21", "mehdi@gmail.com", "marocaine", "it", "leviathan", "mahdu100", deplacement,"user"
            );
            // Sauvegarder les Employes
            employeRepository.save(aya);
            employeRepository.save(mehdi);

        };
    }
}
