package com.example.bookstore.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
    @Past(message = "Date of Birth must be past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "Please Enter Eduction.")
    private String education;

    public Author() {
    }

    public Author(String name, LocalDate dateOfBirth, String education) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.education = education;
    }

    @OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST)
    private List<Books> books=
            new ArrayList<>();

    public void addBook(Books book){
        book.setAuthor(this);
        books.add(book);
    }

}
