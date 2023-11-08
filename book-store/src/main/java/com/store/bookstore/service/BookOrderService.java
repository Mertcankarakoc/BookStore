package com.store.bookstore.service;

import com.store.bookstore.model.Book;
import com.store.bookstore.model.BookOrder;
import com.store.bookstore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookOrderService {

    private final BookService bookService;
    private final OrderRepository orderRepository;
    //uygulamanızın çeşitli noktalarında loglama mesajları oluşturmanıza ve kaydetmenize yardımcı olur
    private final Logger logger = LoggerFactory.getLogger(BookOrderService.class);


    public BookOrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public BookOrder putAnOrder(List<Integer> bookIdList, String userName){
    List<Optional<Book>> bookList = bookIdList.stream()
            .map(bookService::findBookById)
            .collect(Collectors.toList());

    Double totalPrice = bookList.stream().map(optionalBook -> optionalBook
                    .map(Book::getPrice).orElse(0.0))
                    .reduce(0.0,Double::sum);

    BookOrder bookOrder = BookOrder.builder()
            .bookList(bookIdList)
            .totalPrice(totalPrice)
            .userName(userName)
            .build();

    return orderRepository.save(bookOrder);

    }
}
