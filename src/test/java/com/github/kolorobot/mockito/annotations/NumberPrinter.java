package com.github.kolorobot.mockito.annotations;

class NumberPrinter {

    private Calculator calculator;
    private Printer printer;

    public NumberPrinter(Calculator calculator, Printer printer) {
        this.calculator = calculator;
        this.printer = printer;
    }

    public void printNumbers(int limit) {
        for (int i = 1; i <= limit; i++) {
            printer.print(calculator.calculate(i));
        }
    }
}
