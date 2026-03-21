package com.HibernateJpa.Controller;


import com.HibernateJpa.Enitity.ProductEnitity;
import com.HibernateJpa.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {


    private  final int pageSize=5;

    @Autowired

    ProductRepo Repo;


    @GetMapping
    public List<ProductEnitity> getall(@RequestParam(defaultValue = "") String title,  @RequestParam(defaultValue = "id") String sortBody,@RequestParam(defaultValue = "1") Integer pageNumber){

        return  Repo.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber,pageSize,Sort.by(
                   Sort.Order.asc(sortBody),
                   Sort.Order.asc("price")
                ))
        );
    }

}
