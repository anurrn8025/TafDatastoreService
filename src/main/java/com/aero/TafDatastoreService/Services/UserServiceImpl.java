package com.aero.TafDatastoreService.Services;

import com.aero.TafDatastoreService.Models.Users;
import com.aero.TafDatastoreService.Repositories.UsersRepository;
import com.aero.TafDatastoreService.Services.Interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
   /* @Value("${microservice.api.url}")
    private String microserviceUrl;

    @Autowired
    private RestTemplate restTemplate;*/

    private final UsersRepository userRepository;

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Users getUserDetails(Long id) {
        System.out.println("get user details");
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users addUser(Users users) {
        System.out.println("Add new user");
        return userRepository.save(users);
    }

    @Override
    public Users updateUser(Long id,Users users) {
        System.out.println("Update existing user details");
        //users.setEmail(users.getEmail());
       Long userid = id;
        System.out.println("Userid is = "+ id);

        Optional<Users> existingUser = userRepository.findById(userid);

        if (existingUser.isPresent()) {
            Users upuser = existingUser.get();
            upuser.setUsername(users.getUsername());
            upuser.setEmail(users.getEmail());
            upuser.setPhone(users.getPhone());
            upuser.setCreated_at(users.getCreated_at());
            upuser.setUpdated_at(users.getUpdated_at());
            return userRepository.save(upuser);

        }
        else{
        new RuntimeException("User does not exists");
        return null;
        }


    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("delete existing user ");
         userRepository.deleteById(id);
    }


}
