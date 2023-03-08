package org.example.servise.impl;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.servise.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkUserExist(User user) {
        User users = userRepository.getUserByName(user.getName());
        return users != null;
    }
}
