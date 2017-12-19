package com.flipzon.ecom.dao;

import com.flipzon.ecom.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @InjectMocks
    @Autowired
    private UserDAOImpl userDAO;

    @Mock
    private EntityManager entityManager;

    @Test
    public void shouldReturnTrueIfAddUserIsSuccessful() {
        User user = mock(User.class);
        when(entityManager.contains(any())).thenReturn(true);
        boolean result = userDAO.addUser(user);
        Assert.assertEquals(true,result);
    }




}
