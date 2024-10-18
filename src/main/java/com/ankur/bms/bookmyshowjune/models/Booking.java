package com.ankur.bms.bookmyshowjune.models;

import java.util.*;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    @ManyToOne
    private User user;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingstatus;

    private Date bookedDate;

    @OneToMany
    private List<Payment> payments;



}
