package com.taran.navitex.service;

import com.taran.navitex.entity.User;
import com.taran.navitex.exception.NavitexServiceException;

import java.util.List;

public interface UserService {
    User find(String id) throws NavitexServiceException;

    List<User> findAll();

    void create(User user);

    void update(User user);

    void remove(User user);

    boolean remove(String id) throws NavitexServiceException;
}
