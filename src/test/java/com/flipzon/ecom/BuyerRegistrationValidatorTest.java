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

        User user = createUserObject();
        user.setEmailId("jhvjfghgfk.com");
        String validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setEmailId("jhvjfghgfk.com@");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());

    }

    private User createUserObject() {
        User user = new User();
        user.setAddress("TestUser");
        user.setEmailId("test@thoughtworks.com");
        user.setMobile("8095395188");
        user.setName("TestUser");
        user.setUserName("TestUserName");
        user.setDate(new Date());
        user.setUserName("TestName");
        user.setPassword("**********");
        user.setGender("Male");
        return user;
    }

    @Test
    public void verifyMobileNumberIsInvalid() {

        User user = createUserObject();
        user.setMobile("jfdhg");
        String validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setMobile("");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setMobile("123456789012");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }

    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenNonMandatoryFieldsAreEmpty() {

        User user = createUserObject();
        user.setUserName("");
        String validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUserObject();
        user.setName("");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUserObject();
        user.setPassword("");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUserObject();
        user.setAddress("");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUserObject();
        user.setPassword("");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenFieldsExceededMaxLength() {

        User user = createUserObject();
        user.setUserName("TestUserNameIsmaxLength=testetestestestest");
        String validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUserObject();
        user.setName("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUserObject();
        user.setPassword("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk\"");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUserObject();
        user.setAddress("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk\"jhdfgkljghgdfhfgdjkklfhmgkghdfggfdhkgfdkgfh");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenInvalidGenderIsProvided() {
        User user = createUserObject();
        user.setGender("Mal");
        String validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setGender("Fenbxv,mngfj");
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }

    @Test
    public void verifyIfValidationMessageIsEmptyWhenValidPayloadIsProvided() {
        User user = createUserObject();
        String validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        System.out.println(validationMessage);
        Assert.assertTrue(validationMessage.isEmpty());


    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenDateIsInvalid() {

        Calendar calendar = Calendar.getInstance();
        User user = createUserObject();
        user.setDate(null);
        String validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = calendar.getTime();
        user.setDate(futureDate);
        validationMessage = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);
        Assert.assertFalse(validationMessage.isEmpty());

    }

}
