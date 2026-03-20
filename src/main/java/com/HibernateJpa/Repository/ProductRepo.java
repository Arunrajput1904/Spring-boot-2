package com.HibernateJpa.Repository;

//import com.HibernateJpa.Enitity.Product;
import com.HibernateJpa.Enitity.ProductEnitity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepo  extends JpaRepository<ProductEnitity, Long> {
    Page<ProductEnitity> findAll(Pageable pageable);

    List<ProductEnitity> findByPriceBetween(BigDecimal min, BigDecimal max);

//    List<ProductEnitity> findByPriceGreaterThan(BigDecimal val);

    List<ProductEnitity> findByPriceLessThan(BigDecimal val);

    List<ProductEnitity> getByPriceLessThan(BigDecimal val);

    int countByPriceLessThan(BigDecimal val);

    List<ProductEnitity> findByPriceIsNull();

    List<ProductEnitity> findByCreatedAtIsNull();

//    List<ProductEnitity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEnitity> findByTitleContainingIgnoreCase(String name,Pageable pageable);



    List<ProductEnitity> findByPriceGreaterThanAndQuantityLessThan(BigDecimal price, int quantity);

    @Query("select e from ProductEnitity e where e.price=:price and e.quantity=:quantity")
    List<ProductEnitity> findByPriceAndQuantity(BigDecimal price, int quantity);

    List<ProductEnitity> findByPriceOrQuantity(BigDecimal bigDecimal, int i);
}
