package com.prueba.crudservice.demo.repositories;

import com.prueba.crudservice.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findById(Long id);
}
