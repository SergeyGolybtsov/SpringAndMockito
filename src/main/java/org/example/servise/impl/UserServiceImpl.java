package org.example.servise.impl;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.repository.impl.UserRepositoryImpl;
import org.example.servise.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public boolean checkUserExist(User user) {
        User users = userRepository.getUserByName(user.getName());
        if (users != null) {
            return true;
        }else
            return false;
    }
}
