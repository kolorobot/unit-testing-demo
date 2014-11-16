package com.github.kolorobot.mockito.annotations;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
