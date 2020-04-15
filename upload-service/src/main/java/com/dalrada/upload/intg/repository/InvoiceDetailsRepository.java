
/**
 * 
 */
package com.dalrada.upload.intg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dalrada.upload.intg.entity.InvoiceDetails;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Long> {

}
