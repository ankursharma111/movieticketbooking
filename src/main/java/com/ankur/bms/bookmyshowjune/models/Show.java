package com.ankur.bms.bookmyshowjune.models;

import java.util.*;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shows")
public class Show extends BaseModel {

    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

}
