package org.example.repository.impl;

import org.example.model.User;
import org.example.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public final List<User> user = new ArrayList<>();

    public UserRepositoryImpl() {
        user.add(new User("Дмитрий"));
        user.add(new User("Сергей"));
    }

    @Override
    public User getUserByName(String name) {
        return user.stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return user;
    }
}
