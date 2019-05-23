package com.taran.navitex.service.impl;

import com.taran.navitex.entity.User;
import com.taran.navitex.exception.NavitexServiceException;
import com.taran.navitex.repository.UserRepository;
import com.taran.navitex.service.UserService;
import com.taran.navitex.service.util.PositiveNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final String NOT_EXIST_MESSAGE = "Country doesn't exist with id = ";
    private static final String INCORRECT_VALUE = " - it's not a long or incorrect value.";
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User find(String id) throws NavitexServiceException {
        if (PositiveNumberValidator.validate(id)) {
            Optional<User> user = userRepository.find(Long.valueOf(id));
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new NavitexServiceException(NOT_EXIST_MESSAGE + id);
            }
        } else {
            throw new NavitexServiceException(id + INCORRECT_VALUE);
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void remove(User user) {
        userRepository.remove(user);
    }

    @Override
    public boolean remove(String id) throws NavitexServiceException {
        if (PositiveNumberValidator.validate(id)) {
            return userRepository.remove(Long.valueOf(id));
        } else {
            throw new NavitexServiceException(id + INCORRECT_VALUE);
        }
    }
}
