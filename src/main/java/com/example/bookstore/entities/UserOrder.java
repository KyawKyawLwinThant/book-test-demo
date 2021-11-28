package com.example.bookstore.entities;


import lombok.Getter;
import lombok.Setter;
import org.h2.engine.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private UserRegister userRegister;
    @ManyToMany
    private List<Books> books=new ArrayList<>();

    private LocalDate orderDate;
}
