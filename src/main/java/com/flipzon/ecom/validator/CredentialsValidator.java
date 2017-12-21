package com.flipzon.ecom.validator;

import com.flipzon.ecom.entity.Credentials;

public class CredentialsValidator {

    public static String validateUserCredentials(Credentials credentials) {
        StringBuilder message = new StringBuilder();

        String userName = credentials.getUserName();

        if( userName == null || userName.isEmpty())
            message.append("Provide valid user name"+System.lineSeparator());

        String password = credentials.getPassword();

        if(password == null || password.isEmpty())
            message.append("Provide valid password"+System.lineSeparator());

        return String.valueOf(message);
    }
}
