package com.ankur.bms.bookmyshowjune.repositories;

import com.ankur.bms.bookmyshowjune.models.*;

import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User,Long> {


    @Override
    Optional<User> findById(Long UserId);
    // It will give us User detail by given UserId.


    @Override
    List<User> findAllById(Iterable<Long> longs);
    // It will give us a List<User> by given List<UserId>.



    Optional<User> findByEmail(String email);

    Optional<String> findAllByPassword(String password);
}
