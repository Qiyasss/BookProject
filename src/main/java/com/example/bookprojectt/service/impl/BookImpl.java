package com.example.bookprojectt.service.impl;

import com.example.bookprojectt.dto.BookEntityDto;
import com.example.bookprojectt.enums.ErrorCodeEnum;
import com.example.bookprojectt.exception.UserException;
import com.example.bookprojectt.repository.BookRepo;
import com.example.bookprojectt.entity.BookEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookImpl implements BookInterface {

    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;


    @Override
    public void create(BookEntityDto bookEntity) {

        BookEntity book = BookEntity.builder().
                id(bookEntity.getId()).
                author(bookEntity.getAuthor()).
                bookName(bookEntity.getBookName()).
                category(bookEntity.getCategory()).
                pageNum(bookEntity.getPageNum()).
                build();

        bookRepo.save(book);
    }


    @Override
    public BookEntity updatebk(int id, BookEntityDto book) {
        Optional<BookEntity> updateBook = bookRepo.findById(id);
        if (updateBook.isPresent()) {

            BookEntity newBook = updateBook.get();

            newBook.setAuthor(book.getAuthor());
            newBook.setBookName(book.getBookName());
            newBook.setCategory(book.getCategory());
            newBook.setPageNum(book.getPageNum());

            return bookRepo.save(newBook);

        }
        return null;
    }

    public BookEntityDto findbyId(int id) {

        Optional<BookEntity> book = bookRepo.findById(id);
        System.out.println(book.isEmpty());
        if(book.isEmpty()) {
            throw  new UserException(ErrorCodeEnum.USER_NOT_FOUND);
        }
        return book.map(bookE -> modelMapper.map(bookE, BookEntityDto.class)).orElseThrow();
    }

    @Override
    public void delete(int id) {
        bookRepo.deleteById(id);
    }

    @Override
    public List<BookEntity> getAllBookInfo() {
        return bookRepo.findAll();

    }
}
