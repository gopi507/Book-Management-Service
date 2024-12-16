package com.example.demoProject.controller;

import com.example.demoProject.model.Book;

import com.example.demoProject.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest(value = BookController.class)
public class BookControllerTest {


    @MockBean
    BookService bookService;

   @Autowired
    BookController bookController;

    @Test
    void testBookList(){
        List<Book> list = new ArrayList<>();
        Book book = new Book(1,"java","james","edu", 4);
        list.add(book);
        when(bookService.getAllBooks()).thenReturn(list);
        assertEquals(list, bookController.bookList());
    }

    @Test
    void  testGetByBookId(){

        Book book = new Book(1,"java","james","edu", 4);
        when(bookService.getByBookId(1)).thenReturn(book);

        assertEquals(book,bookController.getByBookId(1));

    }
    @Test
    void testCreateBook(){

        Book book = new Book(1,"java","james","edu", 4);
        when(bookService.createBooks(book)).thenReturn(book);
        assertEquals(book,bookController.createBook(book));
    }
    @Test
    void testDeleteBooks() {
        Book book = new Book(1,"java","james","edu", 4);
        when(bookService.deleteBooks(1)).thenReturn("book deleted successfully");
        String result = bookController.deleteBookId(1);
        assertEquals("book deleted successfully", result);

    }
    @Test
    void testUpdateBooks(){
        Book book = new Book(1,"java","james","edu", 4);

        when(bookService.updateAvailabilityStatus(1,5)).thenReturn(book);
        Book updateBookAvailability=bookController.updateBooks(1,5);
        assertNotNull(updateBookAvailability);
        assertEquals(book,updateBookAvailability);
    }
    @Test
    void  testUpdateBook(){
        Book book = new Book(1,"java","james","edu", 4);
        when(bookService.updateBooks(book)).thenReturn(book);

        assertEquals(book,bookController.updateBook(book));
    }

}
