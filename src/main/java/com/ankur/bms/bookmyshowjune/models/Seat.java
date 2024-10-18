package com.ankur.bms.bookmyshowjune.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity


public class Seat extends BaseModel {

    private String seatNumber;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int seatRow;
    private int seatCol;


}
