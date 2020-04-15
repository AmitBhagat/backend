
/**
 * 
 */
package com.dalrada.reconcile.integration.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dalrada.reconcile.integration.entity.OrderDetails;
import com.dalrada.reconcile.integration.entity.ShippingDetails;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Repository
public interface ShippingRepository extends JpaRepository<ShippingDetails , Long> {

    ShippingDetails findByPoNumber(String poNumber);
    
    @Query("select shipping from ShippingDetails shipping")
	Stream<ShippingDetails> findByPoNumber(List<String> poNumbers);
}
