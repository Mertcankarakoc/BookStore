package com.store.bookstore.repository;

import com.store.bookstore.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<BookOrder,Integer> {
}
