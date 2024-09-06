package com.example.demo.Services;



import com.example.demo.Models.EmployeEtranger;
import com.example.demo.Models.EmployeMarocain;
import com.example.demo.Models.MoyensGeneraux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeEtrangerService {

    @Autowired
    private MoyensGenerauxService moyensGenerauxService;

    @Autowired
    private EmployeMarocainService employeMarocainService;

    public void annoncerDateArriveeEtDepart(int employeEtrangerId, Date dateArrivee, Date dateDepart, int employeMarocainId) {
        EmployeEtranger employeEtranger = getEmployeEtrangerById(employeEtrangerId);
        MoyensGeneraux moyensGeneraux = moyensGenerauxService.getMoyensGeneraux();
        EmployeMarocain employeMarocainChoisi = employeMarocainService.getEmployeMarocainById(employeMarocainId);

        if (employeEtranger != null && moyensGeneraux != null) {
            employeEtranger.setEmployeMarocainChoisi(employeMarocainChoisi);
            employeEtranger.annoncerDateArriveeEtDepart(dateArrivee, dateDepart, moyensGeneraux);
        }
    }

    private EmployeEtranger getEmployeEtrangerById(int id) {
        // Logique pour récupérer l'employé étranger par ID (par exemple, depuis une base de données)
        return new EmployeEtranger(); // Exemple
    }
}
