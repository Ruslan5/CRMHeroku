package ua.com.feiron.validation;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.feiron.domain.SignInForm;

@Component
public class SignInValidator implements Validator{
    public boolean supports(Class<?> clazz) {
        return SignInForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        SignInForm signInForm = (SignInForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "Name must not be empty.");
        String username = signInForm.getUsername();
        if ((username.length()) > 16) {
            errors.rejectValue("username", "username.tooLong", "Name must not more than 16 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(signInForm.getPassword()).equals(signInForm
                .getDoublepassword())) {
            errors.rejectValue("doublepassword", "doublepassword.passwordDontMatch", "Passwords don't match.");
        }

        if( !EmailValidator.getInstance().isValid( signInForm.getEmail() ) ){
            errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        }
    }
}
