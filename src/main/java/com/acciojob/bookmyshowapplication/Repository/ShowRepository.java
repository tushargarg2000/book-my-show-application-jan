package com.acciojob.bookmyshowapplication.Repository;

import com.acciojob.bookmyshowapplication.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {
}
