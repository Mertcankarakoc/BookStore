package com.store.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

@Table
@Data
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String author;
    private double price;
    private Integer stock;


}