package com.ankur.bms.bookmyshowjune.dtos;


import lombok.*;

import java.util.*;

@Getter
@Setter
public class BookMovieRequestDto {

    Long userId;
    Long showId;
    List<Long>showSeatIds;


}
