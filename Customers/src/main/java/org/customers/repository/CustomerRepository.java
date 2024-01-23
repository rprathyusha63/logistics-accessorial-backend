package org.customers.repository;

import org.customers.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Vendor, Long> {
    @Query("SELECT u FROM Vendor u WHERE u.warehouse.warehouseId = :warehouse_id")
    public List<Vendor> findVendorsByWarehouseId(@Param("warehouse_id") long warehouse_id);
}