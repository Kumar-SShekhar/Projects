package com.librarymanagementsystem.LibraryManagementSystem.service;

import com.librarymanagementsystem.LibraryManagementSystem.model.Book;
import com.librarymanagementsystem.LibraryManagementSystem.model.User;
import com.librarymanagementsystem.LibraryManagementSystem.repository.BookRepository;
import com.librarymanagementsystem.LibraryManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId);
        User user = userRepository.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        return null;
    }

    public Book returnBook(Long bookId) {
        Book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        // If book not found
        return null;
    }


    public List<Book> findBooksByBorrowed() {
        return bookRepository.findByBorrowedIsTrue();
    }

    public List<Book> findAvailableBooks() {
        return bookRepository.findByBorrowedIsFalse();
    }

    public List<Book> findBookByStartingLetter(char ch) {
        return bookRepository.findByTitleStartingWith(ch);
    }

    public List<Book> findAllBooksWithSorted(String field){
        return bookRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public Page<Book> findAllBooksWithPagination(Integer pageNumber, Integer pageSize){
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNumber,pageSize));
        return bookPage;
    }

    public Page<Book> findAllBooksWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String field)
    {
        Page<Book> bookPageSorted = bookRepository.findAll(PageRequest.of(pageNumber,pageSize).withSort(Sort.by(field)));
        return bookPageSorted;
    }
}

