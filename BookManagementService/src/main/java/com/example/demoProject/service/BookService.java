package com.example.demoProject.service;

import com.example.demoProject.model.Book;
import com.example.demoProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getByBookId(int id){
        return bookRepository.findByBookId(id);
    }
    public Book createBooks(Book book){
        return bookRepository.save(book);
    }
    public Book updateBooks(Book book){
       Book book1=bookRepository.findByBookId(book.getBookId());
       book1.setTitle(book.getTitle());
       book1.setAuthor(book.getAuthor());
       book1.setGenre(book.getGenre());
       book1.setAvailabilityStatus(book.getAvailabilityStatus());
       return bookRepository.save(book1);
    }
    public Book updateAvailabilityStatus(int id, int availabilityStatus) {
        Book book = bookRepository.findByBookId(id);
        if (book != null) {
            book.setAvailabilityStatus(availabilityStatus);
            return bookRepository.save(book);
            } else {
                throw new RuntimeException("Book not found with ID: " + id);
        }
        }


    public String deleteBooks(int id){
        Book book=bookRepository.findByBookId(id);
        bookRepository.delete(book);
        return "book deleted successfully";
    }


}
