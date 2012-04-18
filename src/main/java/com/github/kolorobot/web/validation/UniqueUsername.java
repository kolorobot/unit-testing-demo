package com.github.kolorobot.web.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.*;

import javax.validation.*;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Documented
public @interface UniqueUsername {
	  String message() default "user with this name already exists";
	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};
}
