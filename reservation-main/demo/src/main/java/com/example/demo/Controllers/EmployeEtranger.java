package com.example.demo.Controllers;

import com.example.demo.Models.EmployeEtranger;
import com.example.demo.Services.EmployeEtrangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/employe-etranger")
public class EmployeEtrangerController {

    @Autowired
    private EmployeEtrangerService employeEtrangerService;

    @PostMapping("/{id}/annoncerVisite")
    public void annoncerVisite(@PathVariable int id, @RequestParam Date dateArrivee, @RequestParam Date dateDepart, @RequestParam int employeMarocainId) {
        employeEtrangerService.annoncerDateArriveeEtDepart(id, dateArrivee, dateDepart, employeMarocainId);
    }
}
