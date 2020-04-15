package com.dalrada.reconcile.integration.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dalrada.reconcile.integration.entity.OrderDetails;
/**
 * @author Sneha
 *
 */

//this the data access layer
@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Long>{
	
	@Query("select order from OrderDetails order where order.orderDate between :startDate and :endDate")
	Stream<OrderDetails> getAllBetween(String startDate , String endDate);
	
	@Query("select order from OrderDetails order")
	Stream<OrderDetails> getAll();

}
