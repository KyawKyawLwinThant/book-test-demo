package com.example.bookstore.service;


import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Books;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @Transactional
    public void createDB(){
        Author author1=new Author("John Doe", LocalDate.of(1990,3,11),"BA(Hons:)");
        Author author2=new Author("John William", LocalDate.of(2000,3,12),"MSC(His:)");
        Author author3=new Author("John SoHara", LocalDate.of(2001,6,11),"BSC:(Hons:)");

        Books book1=new Books("History","World History","World History Details",LocalDate.now(),25.3);
        Books book2=new Books("History","Second War World","World History Details",LocalDate.now(),30.3);
        Books book3=new Books("Novel","Farewell To Arms","Good War Novels",LocalDate.now(),50.3);
        Books book4=new Books("Novel","A Tale of Tow Cities","true love",LocalDate.now(),45.3);
        Books book5=new Books("Novel","Snowflake","family novels",LocalDate.now(),25.3);
        Books book6=new Books("Horror","Dragon Nest","Dragon Nest",LocalDate.now(),25.3);
        Books book7=new Books("Programming","Java","Complete Reference",LocalDate.now(),25.3);
        Books book8=new Books("Programming","Groovy","Groovy Details",LocalDate.now(),25.3);


       // author1.getBooks().add(book1);
        //book1.setAuthor(author1);
        author1.addBook(book1);
        author1.addBook(book2);
        author2.addBook(book3);
        author2.addBook(book4);
        author2.addBook(book5);
        author3.addBook(book6);
        author3.addBook(book7);
        author3.addBook(book8);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

    }

    @Transactional
    public List<Books> findAllBooks(){
        return bookRepository.findAll();
    }



}
