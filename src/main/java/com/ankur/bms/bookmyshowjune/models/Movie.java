package com.ankur.bms.bookmyshowjune.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String name;


}
