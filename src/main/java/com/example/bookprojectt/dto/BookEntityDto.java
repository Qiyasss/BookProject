package com.example.bookprojectt.dto;

import jakarta.persistence.Column;
import lombok.Data;
import java.io.Serializable;

@Data
public class BookEntityDto implements Serializable {

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
