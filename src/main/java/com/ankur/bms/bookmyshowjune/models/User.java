package com.ankur.bms.bookmyshowjune.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String username;
    private String email;
    private String password;



}



