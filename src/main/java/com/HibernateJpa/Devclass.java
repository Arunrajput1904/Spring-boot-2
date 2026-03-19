package com.HibernateJpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service

public class Devclass implements  DataService{
    @Override
    public String getdata() {
        return "Hello Dev";
    }
}
