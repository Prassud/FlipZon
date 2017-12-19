package com.flipzon.ecom;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.validator.BuyerRegistrationValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class BuyerRegistrationValidatorTest {

    @Test
    public void verifyEmailIdIsInvalid() {

        User user = createUser();
        user.setEmailId("jhvjfghgfk.com");
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setEmailId("jhvjfghgfk.com@");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());

    }

    private User createUser() {
        User user = new User();
        user.setAddress("TestUser");
        user.setEmailId("test@thoughtworks.com");
        user.setMobile("8095395188");
        user.setName("TestUser");
        user.setUserName("TestUserName");
        user.setDate(new Date());
        user.setUserName("TestName");
        user.setPassword("sdfghyu");
        user.setUserType("Buyer");
        user.setGender("Male");
        return user;
    }

    @Test
    public void verifyMobileNumberIsInvalid() {

        User user = createUser();
        user.setMobile("jfdhg");
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setMobile("");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setMobile("123456789012");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }

    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenNonMandatoryFieldsAreEmpty() {

        User user = createUser();
        user.setUserName("");
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setName("");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setPassword("");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUser();
        user.setAddress("");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUser();
        user.setPassword("");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenFieldsExceededMaxLength() {

        User user = createUser();
        user.setUserName("TestUserNameIsmaxLength=testetestestestest");
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setName("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setPassword("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk\"");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUser();
        user.setAddress("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk\"jhdfgkljghgdfhfgdjkklfhmgkghdfggfdhkgfdkgfh");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenInvalidGenderIsProvided() {
        User user = createUser();
        user.setGender("Mal");
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setGender("Fenbxv,mngfj");
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }

    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenUserTypeIsValid() {
        User user = createUser();
        user.setUserType("fff");
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertEquals("Invalid User Type" + System.lineSeparator(), validationMessage);

    }


    @Test
    public void verifyIfValidationMessageIsEmptyWhenValidPayloadIsProvided() {
        User user = createUser();
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        System.out.println(validationMessage);
        Assert.assertTrue(validationMessage.isEmpty());

    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenDateIsInvalid() {

        Calendar calendar = Calendar.getInstance();
        User user = createUser();
        user.setDate(null);
        String validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = calendar.getTime();
        user.setDate(futureDate);
        validationMessage = BuyerRegistrationValidator.validateBuyer(user);
        Assert.assertFalse(validationMessage.isEmpty());

    }

}
