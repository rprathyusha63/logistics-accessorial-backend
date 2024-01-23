package org.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.warehouse.domain.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
