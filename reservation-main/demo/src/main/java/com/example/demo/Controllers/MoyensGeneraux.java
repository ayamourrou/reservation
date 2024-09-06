package com.example.demo.Controllers;

import com.example.demo.Models.Reservation;
import com.example.demo.Services.MoyensGenerauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moyens-generaux")
public class MoyensGenerauxController {

    @Autowired
    private MoyensGenerauxService moyensGenerauxService;

    @GetMapping("/reservations")
    public List<Reservation> consulterReservations() {
        return moyensGenerauxService.consulterReservations();
    }
}
