package com.flipzon.ecom.validator;

import com.flipzon.ecom.entity.Credentials;
import org.junit.Assert;
import org.junit.Test;

public class CredentialsValidatorTest {

    @Test
    public void verifyMessageIsEmptyWhenValidCredentialsProvided() {
        Credentials credentials = new Credentials();
        credentials.setUserName("test");
        credentials.setPassword("test");
        String message = CredentialsValidator.validateUserCredentials(credentials);
        Assert.assertTrue(message.isEmpty());
    }

    @Test
    public void verifyMessageWhenUserNameNotProvided() {
        String expectedMessage = "Provide valid user name"+System.lineSeparator();
        Credentials credentials = new Credentials();
        credentials.setUserName("");
        credentials.setPassword("test");
        String actualMessage = CredentialsValidator.validateUserCredentials(credentials);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyMessageWhenPasswordNotProvided() {
        String expectedMessage = "Provide valid password"+System.lineSeparator();
        Credentials credentials = new Credentials();
        credentials.setUserName("test");
        credentials.setPassword("");
        String actualMessage = CredentialsValidator.validateUserCredentials(credentials);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyMessageWhenUserNameAndPasswordNotProvided() {
        String expectedMessage = "Provide valid user name" + System.lineSeparator() + "Provide valid password" +System.lineSeparator();
        Credentials credentials = new Credentials();
        System.out.println(CredentialsValidator.validateUserCredentials(credentials));
        String actualMessage = CredentialsValidator.validateUserCredentials(credentials);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
