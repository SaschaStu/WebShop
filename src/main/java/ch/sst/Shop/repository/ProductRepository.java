package ch.sst.Shop.repository;

import ch.sst.Shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long>{

}