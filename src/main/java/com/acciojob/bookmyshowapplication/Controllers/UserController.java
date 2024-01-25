package com.acciojob.bookmyshowapplication.Controllers;

import com.acciojob.bookmyshowapplication.Requests.AddUserRequest;
import com.acciojob.bookmyshowapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    private String addUser(@RequestBody AddUserRequest addUserRequest){
        String result = userService.addUser(addUserRequest);
        return result;
    }


}
