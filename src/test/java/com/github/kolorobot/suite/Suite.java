package com.github.kolorobot.suite;

import com.github.kolorobot.basic.SamePasswordsValidatorTest;
import com.github.kolorobot.mockito.annotations.NumberPrinterTest;
import org.junit.runner.RunWith;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses(value = {SamePasswordsValidatorTest.class, NumberPrinterTest.class})
public class Suite {

}
