package org.aibles.java.api.crud.reponsitory;
import org.aibles.java.api.crud.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByProductNameContainingIgnoreCase(String productName);
}

