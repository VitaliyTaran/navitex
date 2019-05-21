package com.taran.navitex.repository;

import com.taran.navitex.entity.Sensor;
import com.taran.navitex.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> find(long id);

    List<User> findAll();

    void create(User user);

    void update(User user);

    void remove(User user);

    boolean remove(long id);
}
