package com.librarymanagementsystem.LibraryManagementSystem.service;

import com.librarymanagementsystem.LibraryManagementSystem.model.User;
import com.librarymanagementsystem.LibraryManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(Long userId){
        userRepository.deleteById(userId);
    }

    public List<User> findUserByFirstLetter(char firstLetter) {
        return userRepository.findByNameStartingWithIgnoreCase(firstLetter);
    }
}
