package com.ankur.bms.bookmyshowjune.services;

import com.ankur.bms.bookmyshowjune.models.*;
import com.ankur.bms.bookmyshowjune.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class SeatService {


    SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeat(){

        return this.seatRepository.findAll();
    }
}
