package dmacc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dmacc.beans.Customer;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Apr 10, 2021
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findAll();
}
