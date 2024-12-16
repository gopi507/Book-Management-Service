package com.example.demoProject.service;

import com.example.demoProject.model.Book;
import com.example.demoProject.repository.BookRepository;

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

@WebMvcTest(value = BookService.class)
public class BookServiceTest {

  @MockBean
  private BookRepository bookRepository;

 @Autowired
 BookService bookService;


  @Test
  void testGetAllBooks(){
    List<Book> list = new ArrayList<>();
    Book book = new Book(1,"java","james","edu", 4);
    list.add(book);
    when(bookRepository.findAll()).thenReturn(list);
    assertEquals(list, bookService.getAllBooks());
  }
@Test
  void  testGetByBookId(){
    Book book = new Book(1,"java","james","edu", 4);
    when(bookRepository.findByBookId(1)).thenReturn(book);

    assertEquals(book,bookService.getByBookId(1));

  }
  @Test
  void testCreateBooks(){

    Book book = new Book(1,"java","james","edu", 4);
    when(bookRepository.save(book)).thenReturn(book);
    assertEquals(book,bookService.createBooks(book));
  }
@Test
  void testDeleteBooks(){
    Book book = new Book(1,"java","james","edu", 4);
     doNothing().when(bookRepository).delete(book);
     when(bookRepository.findByBookId(1)).thenReturn(book);
    assertEquals("book deleted successfully",bookService.deleteBooks(1));

  }
  @Test
  void testUpdateAvailabilityStatus(){
      Book book = new Book(1,"java","james","edu", 4);
      when(bookRepository.findByBookId(1)).thenReturn(book);
      when(bookRepository.save(book)).thenReturn(book);
      Book updateBookAvailability=bookService.updateAvailabilityStatus(1,5);
      assertNotNull(updateBookAvailability);
      assertEquals(book,updateBookAvailability);
  }
  @Test
  void testUpdateBooks(){
      Book book = new Book(1,"java","james","edu", 4);
      when(bookRepository.findByBookId(1)).thenReturn(book);
      when(bookRepository.save(book)).thenReturn(book);
      Book updateBooks=bookService.updateBooks(book);
      updateBooks.setTitle("java");
      updateBooks.setAuthor("james h");
      updateBooks.setGenre("education");
      updateBooks.setAvailabilityStatus(5);
      assertEquals(book,updateBooks);

  }

}
