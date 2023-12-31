package com.librarymanagementsystem.LibraryManagementSystem.repository;

import com.librarymanagementsystem.LibraryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByNameStartingWithIgnoreCase(char firstLetter);
}
