package com.github.kolorobot.register.validation;

import org.junit.runner.RunWith;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses(value = {SamePasswordsValidatorTest.class, UniqueUsernameValidatorTest.class})
public class RegistrationSuite {

}
