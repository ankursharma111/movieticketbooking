package com.ankur.bms.bookmyshowjune.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;
    private SeatType seatType;
    private int price;

}
