package com.example.demo.Controllers;

import com.example.demo.Models.Deplacement;
import com.example.demo.Services.DeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/deplacement")
public class DeplacementController {
    private final DeplacementService deplacementService;

    @Autowired
    public DeplacementController(DeplacementService deplacementService) {
        this.deplacementService = deplacementService;
    }

    @GetMapping
    public List<Deplacement> getAllDeplacements() {
        return deplacementService.getAllDeplacements();
    }

    @PostMapping
    public void addDeplacement(@RequestBody Deplacement deplacement) {
        deplacementService.addDeplacement(deplacement);
    }

    @DeleteMapping(path = "{deplacementId}")
    public void deleteDeplacement(@PathVariable("deplacementId") Long deplacementId) {
        deplacementService.deleteDeplacement(deplacementId);
    }

    @GetMapping(path = "{deplacementId}")
    public Deplacement getDeplacementById(@PathVariable("deplacementId") Long deplacementId) {
        return deplacementService.getDeplacementById(deplacementId);
    }
}
