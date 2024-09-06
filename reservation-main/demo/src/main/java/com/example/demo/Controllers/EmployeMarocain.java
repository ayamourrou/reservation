package com.example.demo.Controllers;

import com.example.demo.Models.EmployeMarocain;
import com.example.demo.Models.Reservation;
import com.example.demo.Services.EmployeMarocainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe-marocain")
public class EmployeMarocainController {

    @Autowired
    private EmployeMarocainService employeMarocainService;

    @GetMapping("/reservations")
    public List<Reservation> consulterReservations() {
        return employeMarocainService.consulterReservations();
    }
}
