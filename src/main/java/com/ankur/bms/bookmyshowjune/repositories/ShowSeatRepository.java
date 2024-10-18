package com.ankur.bms.bookmyshowjune.repositories;

import com.ankur.bms.bookmyshowjune.models.*;


import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);
    // Find the list of ShowSeat by given list of ShowSeatIds.
}
