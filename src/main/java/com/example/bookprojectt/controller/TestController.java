package com.example.bookprojectt.controller;

import com.example.bookprojectt.dto.BookEntityDto;
import com.example.bookprojectt.entity.BookEntity;
import com.example.bookprojectt.service.impl.BookInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class TestController {


    private final BookInterface bookInter;

    @PostMapping(value = "/create")
    public void create(@RequestBody BookEntityDto book) {
        bookInter.create(book);
    }

    @GetMapping("/findId/{id}")
    public BookEntityDto findbyId(@PathVariable int id) {
        return bookInter.findbyId(id);
    }

    @GetMapping ("/all")
    public List<BookEntity> getAllBookInfo() {
     return bookInter.getAllBookInfo();
    }

    @DeleteMapping ("/delete/{id}")
    public void delete (@PathVariable int id) {
        bookInter.delete(id);
    }

    @PutMapping ("/update/{id}")
    public BookEntity update (@PathVariable int id, @RequestBody BookEntityDto book) {
        return bookInter.updatebk(id, book);
    }

}
