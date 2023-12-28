package com.librarymanagementsystem.LibraryManagementSystem.repository;

import com.librarymanagementsystem.LibraryManagementSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByBorrowedIsTrue();

    List<Book> findByBorrowedIsFalse();

    public List<Book> findByTitleStartingWith(char ch);
}
