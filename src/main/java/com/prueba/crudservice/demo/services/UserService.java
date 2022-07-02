package com.prueba.crudservice.demo.services;


import com.prueba.crudservice.demo.models.User;
import com.prueba.crudservice.demo.models.dtos.LoginDTO;

public interface UserService {

    User addUser(User user);

    User findById(Long id);

    User login(LoginDTO userData);
}
