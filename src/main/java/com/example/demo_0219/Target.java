package com.example.demo_0219;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Target {

    @Size(max = 5)
    public String foo;

    @NotNull
    public String bar;

    @Pattern(regexp = "\\d{5}")
    public String baz;

    @Max(5)
    public String qux;

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public void setBaz(final String baz) {
        this.baz = baz;
    }

    public void setQux(final String qux) {
        this.qux = qux;
    }

    public String getFoo() {
        return foo;
    }

    public String getBar() {
        return bar;
    }

    public String getBaz() {
        return baz;
    }

    public String getQux() {
        return qux;
    }
}
