package com.aero.TafDatastoreService.Services.Interfaces;

import com.aero.TafDatastoreService.Models.Users;


public interface UserService {


    Users getUserDetails(Long id);
    Users addUser(Users users);
    Users updateUser(Long id,Users users);
    void deleteUser(Long id);
}
