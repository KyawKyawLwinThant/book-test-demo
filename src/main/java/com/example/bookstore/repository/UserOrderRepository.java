package com.example.bookstore.repository;

import com.example.bookstore.entities.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends CrudRepository<UserOrder,Integer> {
}
