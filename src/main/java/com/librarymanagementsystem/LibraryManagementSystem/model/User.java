package com.librarymanagementsystem.LibraryManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")

public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long userId;

    @Column(name="user_name")
    private String name;
    @Column(name="date_of_birth")
    private String dateOfBirth;
    @Column(name = "address")
    private String address;
}
