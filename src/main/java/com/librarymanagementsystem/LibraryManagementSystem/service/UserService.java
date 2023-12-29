package com.librarymanagementsystem.LibraryManagementSystem.service;

import com.librarymanagementsystem.LibraryManagementSystem.model.User;
import com.librarymanagementsystem.LibraryManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public List<User> findUserWithSorted(String field){
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public Page<User> findUsersWithPagination(Integer pageNumber, Integer pageSize){
        Page<User> usersPage = userRepository.findAll(PageRequest.of(pageNumber,pageSize));
        return usersPage;
    }

    public Page<User> findUsersWithPaginationAndSorting(Integer pageNumber, Integer pageSize , String field)
    {
        Page<User> userPageSorted = userRepository.findAll(PageRequest.of(pageNumber,pageSize).withSort(Sort.by(field)));
        return userPageSorted;
    }
}
