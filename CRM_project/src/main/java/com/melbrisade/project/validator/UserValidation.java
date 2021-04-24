package com.melbrisade.project.validator;

import com.melbrisade.project.entities.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Users.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Users users = (Users) object;
        if (users.getPassword().length() < 6) {
            errors.rejectValue("password", "Length", "Password must be at least 6 characters");
        }
        if (!users.getPassword().equals(users.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Match", "Password must match");
        }
    }
}
