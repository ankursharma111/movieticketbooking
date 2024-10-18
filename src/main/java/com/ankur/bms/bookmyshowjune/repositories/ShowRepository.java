package com.ankur.bms.bookmyshowjune.repositories;

import com.ankur.bms.bookmyshowjune.models.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;


public interface ShowRepository extends JpaRepository<Show,Long> {

    @Override
    Optional<Show> findById(Long showId);

}
