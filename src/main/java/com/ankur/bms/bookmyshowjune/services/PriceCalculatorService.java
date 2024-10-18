package com.ankur.bms.bookmyshowjune.services;

import com.ankur.bms.bookmyshowjune.models.*;
import com.ankur.bms.bookmyshowjune.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;


import java.util.*;
@Service
public class PriceCalculatorService {
@Autowired
    ShowSeatTypeRepositories showSeatTypeRepositories;



    public int calculatePrice(List<ShowSeat> showSeats, Show show ){

       List<ShowSeatType> showSeatTypes = showSeatTypeRepositories.findAllByShow(show);
       int amount = 0;

        //List<ShowSeat> showSeats...it is my booking list..which I want to choose to book.
        //I have 4 seats all listed in the showSeats List, I am fetching all types of seats
        // which are present in my show and comparing them and if matched I will add it to the
        //amount....and break;

       for(ShowSeat showSeat : showSeats){
           for(ShowSeatType showSeatType : showSeatTypes){
               if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                   amount = amount + showSeatType.getPrice();
                   break;
               }
           }
       }

       return amount;

    }
}
