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
    private NumberPrinter numberPrinter = new NumberPrinter(calculator, printer);

    @Before
    public void setUp() throws Exception {
        // if MockitoJUnitRunner cannot be use for some reason
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
    public void printsThreeNumbers() {
        // arrange
        when(calculator.calculate(anyInt()))
                .thenReturn("1")
                .thenReturn("2")
                .thenReturn("3");
        doNothing().when(printer).print("1"); // the real method will be called twice for "2" and "3"

        // act
        numberPrinter.printNumbers(3);

        // assert
        verify(calculator, times(3)).calculate(anyInt());
        verify(printer).print("1");
        verify(printer).print("2");
        verify(printer).print("3");
        verifyNoMoreInteractions(printer, calculator);
    }
}