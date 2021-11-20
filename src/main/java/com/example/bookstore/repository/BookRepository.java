package com.example.bookstore.repository;

import com.example.bookstore.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
}
