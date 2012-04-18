package com.github.kolorobot.web.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE}) // class level constraint
@Retention(RUNTIME)
@Constraint(validatedBy = SamePasswordsValidator.class) // validator
@Documented
public @interface SamePasswords {
	String message() default "passwords must be the same"; // default error message
	
	Class<?>[] groups() default {}; // required
	
	Class<? extends Payload>[] payload() default {}; // required
}
