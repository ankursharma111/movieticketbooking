package com.ankur.bms.bookmyshowjune.services;

import com.ankur.bms.bookmyshowjune.exceptions.*;
import com.ankur.bms.bookmyshowjune.models.*;
import com.ankur.bms.bookmyshowjune.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;


import java.util.*;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private PriceCalculatorService priceCalculatorService;
    @Autowired
    private BookingRepository bookingRepository;



    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatId){

    //1-> Get the User from UserId.
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new InvalidUserException("invalid userId");
        }

            User bookedBy = optionalUser.get();

        //2->Get the Show from ShowId.
        Optional<Show> optionalShow = showRepository.findById(showId);

        if(optionalShow.isEmpty()) {
            throw new InvalidShowException("invalid showId");
        }

            Show show = optionalShow.get();

        //3-> Get the List of showSeats from List of showSeatIds from DB.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatId);

        //4-> Check if all seats are AVAILABLE or not.
        for(ShowSeat showSeat : showSeats) {

            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                //5-> If not throw an Exception.
                throw new ShowSeatNotAvailableException("ShowSeat with id: " + showSeat.getId() + " is not available");
            }
        }


        //     NOW WE WILL HANDLE CONCURRENCY

        //6-> Change the status of ShowSeats to be booked to BLOCKED.
        for(ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            //7-> Change the status in the DB as well.
            showSeatRepository.save(showSeat);
        }

        //8-> Create a Booking object.
        Booking booking = new Booking();


        //9-> Save the Booking to DB.
        booking.setBookingstatus(BookingStatus.IN_PROGRESS);
        booking.setUser(bookedBy);
        booking.setShowSeats(showSeats);
        booking.setPayments(new ArrayList<>());
        booking.setCreatedAt(new Date());
        booking.setLastModifiedAt(new Date());



        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, show));

        return bookingRepository.save(booking);






    }
}
