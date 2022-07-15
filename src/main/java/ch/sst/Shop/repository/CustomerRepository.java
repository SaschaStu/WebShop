package ch.sst.Shop.repository;

import ch.sst.Shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerRepository extends JpaRepository<Customer, Long>{

}