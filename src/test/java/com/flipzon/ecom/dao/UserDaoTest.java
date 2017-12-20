package com.flipzon.ecom.dao;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.entity.UserType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @InjectMocks
    @Autowired
    private UserDAOImpl userDAO;

    @Mock
    private EntityManager entityManager;


    @Test
    public void shouldReturnTrueIfAddUserIsSuccessful() {
        User user = new User();
        when(entityManager.contains(user)).thenReturn(true);
        boolean result = userDAO.addUser(user);
        Assert.assertEquals(true, result);
        verify(entityManager, times(1)).contains(user);
    }


}
