package com.HibernateJpa.Enitity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_table", indexes = {
        @Index(name = "sku_index", columnList = "sku")
}, uniqueConstraints = {
        @UniqueConstraint(name = "title_price_unique", columnNames = {"title_x", "price"})
})
public class ProductEnitity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(nullable = false, length = 40)
    private String sku;

    @Column(name = "title_x")
    private String title;

   private BigDecimal price;

    private int quantity;

@CreationTimestamp
    private LocalDateTime createdAt;
@UpdateTimestamp
    private LocalDateTime  updateAt;


@ManyToOne
Department department;

}
