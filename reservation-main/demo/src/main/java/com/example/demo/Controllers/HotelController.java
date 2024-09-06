package com.example.demo.Controllers;

import com.example.demo.Models.Hotel;
import com.example.demo.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public void addHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
    }

    @PutMapping(path = "{hotelId}")
    public void updateHotel(@PathVariable("hotelId") Long hotelId, @RequestBody Hotel hotel) {
        hotelService.updateHotel(hotelId, hotel);
    }

    @DeleteMapping(path = "{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") Long hotelId) {
        hotelService.deleteHotel(hotelId);
    }
}
