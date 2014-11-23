package com.github.kolorobot.mockito.annotations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NumberPrinterTest {

    @Spy
    private Printer printer = new ConsolePrinter();

    @Mock
    private Calculator calculator;

    @InjectMocks
    private NumberPrinter numberPrinter;

    @Before
    public void setUp() throws Exception {
        // if MockitoJUnitRunner cannot be used for some reason
        // MockitoAnnotations.initMocks(this) can be used
    }

    @Test
    public void printsOneNumber() {
        // arrange
        doReturn("1").when(calculator).calculate(1);
        doNothing().when(printer).print("1"); // the real method will not be called

        // act
        numberPrinter.printNumbers(1);

        // assert
        verify(calculator, times(1)).calculate(1);
        verify(printer, times(1)).print("1");
        verifyNoMoreInteractions(printer, calculator);
    }

    @Test
    public void printsCalculatorResultsTenTimes() {
        // arrange
        int limit = 10;
        when(calculator.calculate(anyInt()))
                .thenReturn("0")  // first invocation returns "0"
                .thenReturn("1"); // other invocations return "1"

        doNothing().when(printer)
                .print("1"); // the real method will not be called

        // act
        numberPrinter.printNumbers(limit);
        // assert
        verify(calculator, times(limit)).calculate(anyInt());
        verify(printer, times(1)).print("0");
        verify(printer, times(limit - 1)).print("1");
        verifyNoMoreInteractions(calculator, printer);
    }
}