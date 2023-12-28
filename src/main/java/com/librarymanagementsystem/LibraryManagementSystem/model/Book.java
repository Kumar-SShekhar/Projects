package com.librarymanagementsystem.LibraryManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="book")

public class Book {


//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "book_id")
    private Long bookId;

    @Column(name="title", nullable = false)
    private String title;
    @Column(name="author", nullable = false)
    private String author;
    @Column(name="borrowed")
    private boolean borrowed;

    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JoinColumn(name = "user_id")
    private User borrowedBy;
    @Column(name="borrowed_date" )
    private String borrowedDate;
    @Column(name="return_date")
    private String returnDate;
}
