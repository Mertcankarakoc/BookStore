package com.store.bookstore.controller;

import com.store.bookstore.dto.BookOrderRequest;
import com.store.bookstore.model.BookOrder;
import com.store.bookstore.service.BookOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {

    private final BookOrderService bookOrderService;

    public BookStoreController(BookOrderService bookOrderService) {
        this.bookOrderService = bookOrderService;
    }


    @PostMapping
    public ResponseEntity<BookOrder> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        BookOrder bookOrder = bookOrderService.putAnOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUserName());

        return ResponseEntity.ok(bookOrder);
    }
}
