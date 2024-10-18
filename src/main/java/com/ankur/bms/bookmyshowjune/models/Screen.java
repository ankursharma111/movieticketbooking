package com.ankur.bms.bookmyshowjune.models;

import java.util.*;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{


    private String ScreenNumber;
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

}
