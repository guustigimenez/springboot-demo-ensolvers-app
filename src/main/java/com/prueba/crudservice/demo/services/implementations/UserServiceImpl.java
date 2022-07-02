package com.prueba.crudservice.demo.services.implementations;

import com.prueba.crudservice.demo.exceptions.NotFoundException;
import com.prueba.crudservice.demo.models.User;
import com.prueba.crudservice.demo.models.dtos.LoginDTO;
import com.prueba.crudservice.demo.repositories.UsersRepository;
import com.prueba.crudservice.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User addUser(User user) {
        User newUser = new User();
        try{
             newUser = usersRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException("No se pudo guardar: "+e.getMessage());
        }
        return newUser;
    }

    @Override
    public User findById(Long id) {
        return usersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Credenciales invalidas"));
    }

    @Override
    public User login(LoginDTO userData) {
        return usersRepository.findByEmailAndPassword(userData.getEmail(), userData.getPassword()).orElseThrow(
                () -> new NotFoundException("Credenciales invalidas"));
    }

}
