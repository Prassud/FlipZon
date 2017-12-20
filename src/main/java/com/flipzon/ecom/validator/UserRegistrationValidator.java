package com.flipzon.ecom.validator;

import com.flipzon.ecom.entity.GenderType;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.entity.UserType;
import org.apache.commons.lang.StringUtils;

import java.util.Date;


public class UserRegistrationValidator {

    public static String validateQuorumFields(User user){
        StringBuffer message = new StringBuffer();

        message.append(validateIsEmptyAndMaxLength("name", user.getName(), 30));
        message.append(validateIsEmptyAndMaxLength("address", user.getAddress(), 60));
        message.append(validateSpaceAndIsEmptyAndMaxLength("password", user.getPassword(), 12));
        message.append(validateSpaceAndIsEmptyAndMaxLength("userName", user.getUserName(), 20));
        message.append(validateMobileNumber(user.getMobile()));
        message.append(validateEmailId(user.getEmailId()));
        if(user.getUserType().equals(UserType.BUYER.toString()))
            validateBuyer(user,message);
        else if(user.getUserType().equals(UserType.SELLER.toString()))
            validateSeller(user,message);
        else
            message.append("Invalid User Type" + System.lineSeparator());

        return message.toString();

    }

    public static String validateBuyer(User user, StringBuffer message) {

        message.append(validateGender(user.getGender()));
        message.append(validateDate(user.getDate()));

        return message.toString();
    }
    public static String validateSeller(User user, StringBuffer message) {

        message.append(validatePanNumber(user.getPanNum()));
        message.append(validateExperience(user.getExperience()));

        return message.toString();
    }

    private static String validateIsEmptyAndMaxLength(String fieldName, String fieldValue, int maxLength) {
        fieldValue = StringUtils.trimToEmpty(fieldValue);

        if (StringUtils.isEmpty(fieldValue)) {
            return "Mandatory field " + fieldName + " is not Provided" + System.lineSeparator();
        }

        if (fieldValue.length() > maxLength) {
            return "Maximum allowed length for " + fieldName + " is " + maxLength + " " + System.lineSeparator();
        }
        return "";
    }

    private static String validateSpaceAndIsEmptyAndMaxLength(String fieldName, String fieldValue, int maxLength) {
        String message = validateIsEmptyAndMaxLength(fieldName, fieldValue, maxLength);

        if (!message.isEmpty()) {
            return message;
        }
        if (fieldValue.contains(" "))
            return "Space not allowed for " + fieldName + System.lineSeparator();
        return "";
    }

    private static String validateEmailId(String emailId) {
        String message = validateIsEmptyAndMaxLength("Email", emailId, 40);
        if (!message.isEmpty()) {
            return message;
        }
        int atIndex = emailId.indexOf('@');
        int dotIndex = emailId.indexOf('.');
        if (atIndex == -1 || dotIndex == -1 || atIndex + 1 >= dotIndex) {
            return "Provided email id is not valid" + System.lineSeparator();
        }
        return "";
    }


    private static String validateMobileNumber(String mobileNumber) {
        if (!StringUtils.isNumericSpace(mobileNumber)) {
            return "Provided mobile number is not numeric" + System.lineSeparator();
        }
        if (mobileNumber.length() != 10) {
            return "Mobile Number should be 10 digits" + System.lineSeparator();
        }
        return "";
    }

    private static String validateDate(Date date) {
        if (null == date) {
            return "Provided date is not valid, the allowed format is YYYY-MM-DD" + System.lineSeparator();
        }
        Date currentDate = new Date();

        if (date.after(currentDate)) {
            return "Provided date is future date" + System.lineSeparator();
        }
        return "";
    }

    private static String validateGender(String gender) {
        if (!(GenderType.Male.toString().equals(gender) || GenderType.Female.toString().equals(gender)
                || GenderType.Others.toString().equals(gender))) {
            return "Provided gender is invalid. Provide Male, Female or Others" + System.lineSeparator();
        }
        return "";
    }

    private static String validatePanNumber(String panNumber){
        if(panNumber.length() < 3 || panNumber.length() > 10)
            return "Provided Pan number is invalid. Provide no between 3 to 10 length" + System.lineSeparator();

        return "";

    }
    private static String validateExperience(int experience){
        if(experience == 0)
            return "Please provide a valid experience number.";
        return "";

    }


}
