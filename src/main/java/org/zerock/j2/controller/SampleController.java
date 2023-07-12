package org.zerock.j2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {



    @GetMapping("/one")
    public String[] doA() {
        return new String[]{"AAA","BBB","CCC"};
    }
}
