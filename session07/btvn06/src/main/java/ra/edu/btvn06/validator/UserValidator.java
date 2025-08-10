package ra.edu.btvn06.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ra.edu.btvn06.model.User;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "Username is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.empty", "PhoneNumber is required");

        String regexPhoneNumber = "^0(3|5|7|8|9|1[2689])[0-9]{8}$";
        if (!user.getPhoneNumber().matches(regexPhoneNumber)) {
            errors.rejectValue("phoneNumber", "phoneNumber.invalid", "PhoneNumber is invalid");
        }
    }
}
