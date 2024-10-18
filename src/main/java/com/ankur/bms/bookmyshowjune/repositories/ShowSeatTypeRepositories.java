package com.ankur.bms.bookmyshowjune.repositories;

import com.ankur.bms.bookmyshowjune.models.*;

import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ShowSeatTypeRepositories extends JpaRepository<ShowSeatType, Long> {


   List<ShowSeatType> findAllByShow(Show show);


}
