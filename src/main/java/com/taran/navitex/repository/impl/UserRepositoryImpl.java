package com.taran.navitex.repository.impl;

import com.taran.navitex.entity.Sensor;
import com.taran.navitex.entity.User;
import com.taran.navitex.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String DELETE_USER_SQL = "DELETE FROM users where id=?";
    private static final String FIND_ALL_USER_SQL = "SELECT * FROM users";
    private static final String FIND_USER_SQL = "SELECT * FROM users where id=?";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> find(long id) {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(FIND_USER_SQL, User.class);
        query.setParameter(1, id);
        return Optional.of((User) query.getSingleResult());

    }

    @Override
    public List<User> findAll() {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(FIND_ALL_USER_SQL, User.class);
        return query.getResultList();
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);

    }

    @Override
    public void update(User user) {
        entityManager.merge(user);

    }

    @Override
    public void remove(User user) {
        entityManager.remove(user);
    }

    @Override
    public boolean remove(long id) {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(DELETE_USER_SQL);
        query.setParameter(1, id);
        return query.executeUpdate() == 1;
    }
}
