package com.example.demoProject.repository;

import com.example.demoProject.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {

    public Book findByBookId(int id);

    public Book availabilityStatus(int availabilityStatus);




}
