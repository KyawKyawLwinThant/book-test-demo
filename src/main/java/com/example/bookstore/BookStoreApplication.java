package com.example.bookstore;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class BookStoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }


}
