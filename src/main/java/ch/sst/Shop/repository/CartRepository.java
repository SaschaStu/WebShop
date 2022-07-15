package ch.sst.Shop.repository;

import ch.sst.Shop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

interface CartRepository extends JpaRepository<Cart, Long>{

}
