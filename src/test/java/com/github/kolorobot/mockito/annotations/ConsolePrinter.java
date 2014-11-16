package com.github.kolorobot.mockito.annotations;

class ConsolePrinter implements Printer {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
