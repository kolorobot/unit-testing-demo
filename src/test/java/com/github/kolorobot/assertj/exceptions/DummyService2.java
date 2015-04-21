package com.github.kolorobot.assertj.exceptions;

class DummyService2 {
    public DummyService2() throws Exception {
        throw new Exception("Constructor exception occurred");
    }

    public DummyService2(boolean dummyParam) throws Exception {
        throw new Exception("Constructor exception occurred");
    }
}
