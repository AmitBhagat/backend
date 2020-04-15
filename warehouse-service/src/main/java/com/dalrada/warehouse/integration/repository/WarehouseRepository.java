package com.dalrada.warehouse.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dalrada.warehouse.integration.entity.WarehouseEntity;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long>{

	@Query(" from WarehouseEntity w where w.warehouseCode = :warehouseCode")
	WarehouseEntity getWarehouseByCode(@Param("warehouseCode") Integer warehouseCode);

}
