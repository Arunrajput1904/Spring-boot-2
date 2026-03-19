package com.HibernateJpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class Prodclass implements  DataService {
    @Override
    public String getdata() {
        return "Hello Prod";
    }
}