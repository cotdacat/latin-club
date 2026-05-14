package com.latinclub.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.latinclub.backend.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE " +
           "(:search IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :search, '%'))) " +
           "AND (:category IS NULL OR b.category = :category)")
    List<Book> search(@Param("search") String search,
                      @Param("category") String category);
}