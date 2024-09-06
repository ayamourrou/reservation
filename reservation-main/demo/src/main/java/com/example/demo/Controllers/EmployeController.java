package com.example.demo.Controllers;

import com.example.demo.Models.Employe;
import com.example.demo.Services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employe")
public class EmployeController {
    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('EmployeMarocain', 'EmployeEtranger', 'MoyensGeneraux')")
    public List<Employe> getEmployes() {
        return employeService.getEmployes();
    }

    @PostMapping
    @PreAuthorize("hasRole('MoyensGeneraux')")
    public void addEmploye(@RequestBody Employe employe) {
        employeService.addEmploye(employe);
    }

    @DeleteMapping(path = "{employeId}")
    @PreAuthorize("hasRole('MoyensGeneraux')")
    public void deleteEmploye(@PathVariable("employeId") Long employeId) {
        employeService.deleteEmploye(employeId);
    }

    @PutMapping(path = "{employeId}")
    @PreAuthorize("hasRole('MoyensGeneraux')")
    public void updateEmploye(
            @PathVariable("employeId") Long employeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
    {
        employeService.updateEmploye(employeId, name, email);
    }
}
