package com.example.bookstore.service;


import com.example.bookstore.controller.CartBean;
import com.example.bookstore.entities.UserOrder;
import com.example.bookstore.entities.UserRegister;
import com.example.bookstore.repository.UserOrderRepository;
import com.example.bookstore.repository.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CheckoutService {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRegisterRepository userRegisterRepository;
    @Autowired
    private CartBean cartBean;


    @Transactional
    public UserOrder register(UserRegister user){

        if(cartBean.getBooks().isEmpty()){
            throw new IllegalArgumentException("No Book to checkout.");
        }

        UserRegister userRegister1=new UserRegister();
        userRegister1.setGenderName(user.getGenderName());
        userRegister1.setHobby(user.getHobby());
        userRegister1.setUsername(user.getUsername());
        userRegister1.setPassword(user.getPassword());
        userRegister1.setPhoneNumber(user.getPhoneNumber());
        userRegister1.setStreetName(user.getStreetName());



        UserOrder userOrder=new UserOrder();
        userOrder.setUserRegister(userRegisterRepository.save(userRegister1));
        userOrder.setBooks(cartBean.getBooks());
        userOrder.setOrderDate(LocalDate.now());
        return userOrderRepository.save(userOrder);
    }
}
