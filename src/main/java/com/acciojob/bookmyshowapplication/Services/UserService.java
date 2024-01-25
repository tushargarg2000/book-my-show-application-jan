package com.acciojob.bookmyshowapplication.Services;

import com.acciojob.bookmyshowapplication.Entities.User;
import com.acciojob.bookmyshowapplication.Repository.UserRepository;
import com.acciojob.bookmyshowapplication.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest){

        User user = User.builder().emailId(addUserRequest.getEmailId())
                .name(addUserRequest.getName())
                .build();

        userRepository.save(user);
        return "User has been saved to the DB";

    }
}
