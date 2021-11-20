package com.example.bookstore.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Enter category")
    private String category;
    @NotEmpty(message = "Enter title.")
    private String title;
    @NotEmpty(message = "Enter description")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedYear;
    @DecimalMin(value = "10.0",message = "Price too low!")
    @DecimalMax(value= "100.0",message = "Price too high!")
    private Double price;

    public Books(){

    }

    public Books(String category, String title, String description, LocalDate publishedYear, Double price) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    @ManyToOne
    private Author author;
}
