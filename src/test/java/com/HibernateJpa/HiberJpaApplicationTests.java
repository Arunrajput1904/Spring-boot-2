package com.HibernateJpa;

import com.HibernateJpa.Enitity.ProductEnitity;
import com.HibernateJpa.Repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HiberJpaApplicationTests {


    @Autowired
            @Lazy
    ProductRepo Repo;

	@Test
	void contextLoads() {

        ProductEnitity product=ProductEnitity.builder()
                .sku("pizza242")
                .title("Pizza")
                .price(BigDecimal.valueOf(220.33223445))
                .quantity(12)
                .build();

        ProductEnitity p1=Repo.save(product);

        System.out.println(p1);


	}
    @Test
    void RepoTest(){
      List<ProductEnitity> ll=Repo
              .findByPriceAndQuantity(BigDecimal.valueOf(12.4),4);
        System.out.println(ll);

    }

}
