package com.acciojob.bookmyshowapplication.Repository;

import com.acciojob.bookmyshowapplication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailId(String emailId);

}
