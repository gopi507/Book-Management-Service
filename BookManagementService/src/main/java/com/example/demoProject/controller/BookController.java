package com.example.demoProject.controller;

import com.example.demoProject.model.Book;
import com.example.demoProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping("/bookList")
    public List<Book> bookList(){
        return bookService.getAllBooks();
    }
    @GetMapping("/getByBookId/{id}")
    public Book getByBookId(@PathVariable("id") int id){
        return  bookService.getByBookId(id);
    }
    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book){
        return  bookService.createBooks(book);
    }
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBooks(book);
    }

    @DeleteMapping("/deleteBookId/{id}")
    public  String deleteBookId(@PathVariable("id")int id){
        return bookService.deleteBooks(id);
    }
    @PutMapping("/updateBooks/{id}/{availabilityBooks}")
    public Book updateBooks(@PathVariable("id") int id,@PathVariable("availabilityBooks") int availabilityStatus){
        return  bookService.updateAvailabilityStatus(id,availabilityStatus);
    }
}
