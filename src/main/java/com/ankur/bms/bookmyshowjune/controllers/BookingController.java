package com.ankur.bms.bookmyshowjune.controllers;

import com.ankur.bms.bookmyshowjune.dtos.*;
import com.ankur.bms.bookmyshowjune.models.*;
import com.ankur.bms.bookmyshowjune.services.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

        BookingService bookingService;


        public BookingController(BookingService bookingService) {
            this.bookingService = bookingService;
        }

        @PostMapping("xyzBooking")
    public BookMovieResponseDto bookMovie(@RequestBody BookMovieRequestDto bookMovieRequestDto){

        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();

        try {
            Booking booking = bookingService.bookMovie(bookMovieRequestDto.getUserId(),
                    bookMovieRequestDto.getShowId(),
                    bookMovieRequestDto.getShowSeatIds());

            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setAmount(booking.getAmount());
            bookMovieResponseDto.setBookingResponseStatus(BookingResponseStatus.SUCCESS);
        }
        catch(Exception exception){
            bookMovieResponseDto.setBookingResponseStatus(BookingResponseStatus.FAILURE);
        }


        return bookMovieResponseDto;
    }
}
