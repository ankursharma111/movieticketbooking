package com.ankur.bms.bookmyshowjune.repositories;

import com.ankur.bms.bookmyshowjune.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
