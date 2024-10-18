package com.ankur.bms.bookmyshowjune.controllers;

import com.ankur.bms.bookmyshowjune.models.*;
import com.ankur.bms.bookmyshowjune.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/seat")
public class SeatController {


    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSeat(){
        return seatService.getAllSeat();
    }
}
