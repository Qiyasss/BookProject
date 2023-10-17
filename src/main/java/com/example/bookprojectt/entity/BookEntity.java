package com.example.bookprojectt.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table (name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "author", nullable = false)
    String author;

    @Column(name = "bookName", nullable = false)
    String bookName;

    @Column(name = "bookCategory", nullable = false)
    String category;

    @Column(name = "bookPageNum", nullable = false)
    int pageNum;

}
