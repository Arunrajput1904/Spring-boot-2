package com.HibernateJpa;

import com.HibernateJpa.Enitity.ProductEnitity;
//import com.HibernateJpa.Repository.ProductRepo;
import com.HibernateJpa.Repository.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.PostgreSQLContainer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@AutoConfigureWebTestClient(timeout="100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestConfigcontainer.class)
class HiberJpaApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    ProductRepo productRepo;
    ProductEnitity productEntity;

    @BeforeEach
    void setUp() {
        productEntity = ProductEnitity.builder().sku("Hello").price(new BigDecimal("1.2")).quantity(10).build();

    }



	@Test
	void contextLoads() {
        productRepo.save(productEntity);
        webTestClient.get()
                .uri("/Products")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ProductEnitity.class)
                .hasSize(1);




	}


}
