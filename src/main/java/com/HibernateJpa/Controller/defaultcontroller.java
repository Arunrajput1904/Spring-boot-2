package com.HibernateJpa.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class defaultcontroller {

    @GetMapping("/")
    public String getvalue(){
        return " hello appliction run successfully";
    }

}
