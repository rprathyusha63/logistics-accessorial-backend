package org.product.repository;

import org.product.domain.ProductCategory;
import org.product.domain.VendorProduct;
import org.product.domain.VendorProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorProductRepository extends JpaRepository<VendorProduct, VendorProductId> {
    @Query("SELECT u FROM VendorProduct u WHERE u.warehouse.warehouseId = :warehouse_id")
    List<VendorProduct> findVendorProductsByVendorId(
            @Param("warehouse_id") long warehouse_id);
}
