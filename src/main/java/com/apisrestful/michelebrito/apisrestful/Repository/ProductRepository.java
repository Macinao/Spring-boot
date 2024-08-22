package com.apisrestful.michelebrito.apisrestful.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apisrestful.michelebrito.apisrestful.Models.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID>{}