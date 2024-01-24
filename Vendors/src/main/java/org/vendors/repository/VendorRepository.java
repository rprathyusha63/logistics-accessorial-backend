package org.vendors.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.vendors.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, String> {
    @Query("SELECT u FROM Vendor u WHERE u.warehouse.warehouseId = :warehouse_id")
    public List<Vendor> findVendorsByWarehouseId(@Param("warehouse_id") String warehouse_id);


    @Query("SELECT u FROM Vendor u WHERE u.vendorId = :vendor_id")
    public Vendor findByVendorId(@Param("vendor_id") String vendor_id);

}