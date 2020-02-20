package com.example.demo_0219;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.Map;

@RestController
public class DemoController {

    @PostMapping("/")
    public String foo(@RequestBody @Validated Target target, BindingResult result) {
        return target.getFoo() + " : " + target.getBar() + "\n";
    }


}
