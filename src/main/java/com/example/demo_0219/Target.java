package com.example.demo_0219;

import javax.validation.constraints.Size;

public class Target {
    @Size(max = 16)
    public String foo;

//    @Size(max = 20)
    public void setFoo(String foo) {
        this.foo = foo;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    @Size(max = 10)
    public String getFoo() {
        return foo;
    }

    public String getBar() {
        return bar;
    }

    public String bar;
}
