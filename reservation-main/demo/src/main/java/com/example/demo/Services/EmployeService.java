package com.example.demo.Services;

import com.example.demo.Models.Employe;
import com.example.demo.Repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getEmployes() {
        return employeRepository.findAll();
    }

    public void addEmploye(Employe employe) {
        employeRepository.save(employe);
    }
    public Employe createOrUpdateEmploye(Employe employe) {
        // Ajout de logs pour vérifier le rôle
        System.out.println("Role de l'utilisateur : " + employe.getRole());


        // Logger logger = LoggerFactory.getLogger(EmployeService.class);
        // logger.info("Role de l'utilisateur : {}", employe.getRole());

        if (employe.getRole() == null || employe.getRole().isEmpty()) {
            throw new IllegalArgumentException("Le rôle de l'utilisateur ne peut pas être nul ou vide");
        }

        return employeRepository.save(employe);
    }

    public void deleteEmploye(Long employeId) {
        employeRepository.deleteById(employeId);
    }

    public void updateEmploye(Long employeId, String name, String email) {
        Employe employe = employeRepository.findById(employeId)
                .orElseThrow(() -> new RuntimeException("Employe not found"));

        if (name != null) {
            employe.setName(name);
        }
        if (email != null) {
            employe.setEmail(email);
        }


        employeRepository.save(employe);
    }
}
