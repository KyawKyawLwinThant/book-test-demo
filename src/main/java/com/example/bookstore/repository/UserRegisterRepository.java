package com.example.bookstore.repository;

import com.example.bookstore.entities.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister,Integer> {
}
