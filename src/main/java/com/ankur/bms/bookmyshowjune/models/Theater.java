package com.ankur.bms.bookmyshowjune.models;

import java.util.*;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{

    @ManyToOne
    private Region region;

    private String name;

    @OneToMany
    private List<Screen> screens;
}
