package com.flipzon.ecom.dao;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.entity.UserType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addUser(User user) {
        if (UserType.BUYER.toString().equals(user.getUserType())) {
            user.setPanCard(null);
            user.setExperience(0);
        } else {
            user.setGender(null);
            user.setDate(null);
        }
        entityManager.persist(user);
        return entityManager.contains(user);
    }


}
