package com.example.bookprojectt.service.impl;

import com.example.bookprojectt.dto.BookEntityDto;
import com.example.bookprojectt.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookInterface {

    void create(BookEntityDto bookEntity);


    BookEntity updatebk (int id, BookEntityDto book);

    void delete (int id);

    List<BookEntity> getAllBookInfo();

    BookEntityDto findbyId(int id);
}
