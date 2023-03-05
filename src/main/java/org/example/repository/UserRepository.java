package org.example.repository;

import org.example.model.User;

import java.util.List;

public interface UserRepository {
    User getUserByName(String name);
    List<User> getAllUser();

}
