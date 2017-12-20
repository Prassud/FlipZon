package com.flipzon.ecom;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.validator.UserRegistrationValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class UserRegistrationValidatorTest {



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
        user.setUserType("BUYER");
        user.setGender("Male");
        return user;
    }

    @Test
    public void verifyEmailIdIsInvalid() {

        User user = createUser();
        user.setEmailId("jhvjfghgfk.com");
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setEmailId("jhvjfghgfk.com@");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());

    }

    @Test
    public void verifyMobileNumberIsInvalid() {

        User user = createUser();
        user.setMobile("jfdhg");
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setMobile("");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setMobile("123456789012");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }

    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenNonMandatoryFieldsAreEmpty() {

        User user = createUser();
        user.setUserName("");
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setName("");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setPassword("");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUser();
        user.setAddress("");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUser();
        user.setPassword("");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenFieldsExceededMaxLength() {

        User user = createUser();
        user.setUserName("TestUserNameIsmaxLength=testetestestestest");
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setName("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());

        user = createUser();
        user.setPassword("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk\"");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());


        user = createUser();
        user.setAddress("fdjkhgjkdhgkjdghkfdhl,fdmngfmgfjkgjkdfhfgjkfgdhgdfjdfg.dghlgkgkfldfghlgkfgfk\"jhdfgkljghgdfhfgdjkklfhmgkghdfggfdhkgfdkgfh");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenInvalidGenderIsProvided() {
        User user = createUser();
        user.setGender("Mal");
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());
        user.setGender("Fenbxv,mngfj");
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());


    }

    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenUserTypeIsValid() {
        User user = createUser();
        user.setUserType("fff");
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertEquals("Invalid User Type" + System.lineSeparator(), validationMessage);

    }


    @Test
    public void verifyIfValidationMessageIsEmptyWhenValidPayloadIsProvided() {
        User user = createUser();
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        System.out.println(validationMessage);
        Assert.assertTrue(validationMessage.isEmpty());

    }


    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenDateIsInvalid() {

        Calendar calendar = Calendar.getInstance();
        User user = createUser();
        user.setDate(null);
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = calendar.getTime();
        user.setDate(futureDate);
        validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());

    }
    @Test
    public void verifyIfValidationMessageIsNotEmptyWhenPanNumberIsNotValid() {
        User user = createUser();
        user.setUserType("SELLER");
        user.setPanCard("1234567891");
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertFalse(validationMessage.isEmpty());

    }
    @Test
    public void verifyIfValidationMessageIsEmptyWhenValidSellerPayloadIsProvided() {
        User user = createUser();
        user.setUserType("SELLER");
        user.setPanCard("1234567891");
        user.setExperience(5);
        String validationMessage = UserRegistrationValidator.validateQuorumFields(user);
        Assert.assertTrue(validationMessage.isEmpty());

    }

}
