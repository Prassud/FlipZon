package com.flipzon.ecom.dao;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.entity.UserType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addUser(User user) {
        entityManager.persist(user);
        return entityManager.contains(user);
    }

    @Override
    public UserType getUserType(String userType) {

        Query query = entityManager.createQuery("FROM user_type Where user_type=:userType");
        query.setParameter("userType", userType);
        UserType userTypeResult = (UserType) query.getResultList().get(0);
        return userTypeResult;

    }

}
