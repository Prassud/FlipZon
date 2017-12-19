package com.flipzon.ecom.validator;

import com.flipzon.ecom.entity.User;
import org.apache.commons.lang.StringUtils;

import java.util.Date;


public class BuyerRegistrationValidator {

    public static String validateMandatoryFieldsInPayload(User user) {
        StringBuffer message = new StringBuffer();

        message.append(validateIsEmptyAndMaxLength("name", user.getName(), 30));
        message.append(validateIsEmptyAndMaxLength("address", user.getAddress(), 60));
        message.append(validateSpaceAndIsEmptyAndMaxLength("password", user.getPassword(), 12));
        message.append(validateSpaceAndIsEmptyAndMaxLength("userName", user.getUserName(), 20));
        message.append(validateGender(user.getGender()));
        message.append(validateMobileNumber(user.getMobile()));
        message.append(validateEmailId(user.getEmailId()));
        message.append(validateDate(user.getDate()));

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

        String message = validateIsEmptyAndMaxLength("mobile", mobileNumber, 10);
        if (!message.isEmpty()) {
            return message;
        }
        if (!StringUtils.isNumericSpace(mobileNumber)) {
            return "Provided mobile number is not numeric" + System.lineSeparator();
        }
        if (message.length() != 10) {
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
        if (!("Male".equals(gender) || "Female".equals(gender) || "Others".equals(gender))) {
            return "Provided gender is invalid. Provide Male, Female or Others" + System.lineSeparator();
        }
        return "";
    }


}
