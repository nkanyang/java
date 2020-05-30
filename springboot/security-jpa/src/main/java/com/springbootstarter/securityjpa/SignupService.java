package com.springbootstarter.securityjpa;

import com.springbootstarter.securityjpa.models.User;
import com.springbootstarter.securityjpa.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService{

    @Autowired
    UserRepository userRepository;

    public void createNewUser(UserDto user){
        User poUser = new User(user.getName(), user.getPassword(), true, "ROLE_USER");
        userRepository.save(poUser);
    }
}
