package ch.sst.Shop;

import ch.sst.Shop.model.Cart;
import ch.sst.Shop.model.Customer;
import ch.sst.Shop.model.Producer;
import ch.sst.Shop.model.Product;
import ch.sst.Shop.repository.CartRepository;
import ch.sst.Shop.repository.CustomerRepository;
import ch.sst.Shop.repository.ProducerRepository;
import ch.sst.Shop.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ShopApplication {

	private static final Logger log = LoggerFactory.getLogger(ShopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CustomerRepository customerRepository, ProducerRepository producerRepository, CartRepository cartRepository, ProductRepository productRepository){
		return args -> {



			Producer pro1 = new Producer("Nestle", "Pionierstrasse 1", "Winterthur",8400,"Switzerland","+41 12 345 67 89","zuckerfrei@nestle.cn");

			Product p1 = new Product("Fuze Tea","Gesunder Eistee auf Schwarzteebasis",9.99,100,"Nix gut diese",pro1);

			Cart c1 = new Cart(0.00);

			Customer cus1 = new Customer("Peter", "Lustig","peter.lustig@blume.de","LeterPustig",new Date(),"Bahnhofstrasse 1","Zürich",8000,"Switzerland", c1);



			log.info("Preloading "+producerRepository.save(pro1));
            log.info("Preloading "+productRepository.save(p1));
			log.info("Preloading "+cartRepository.save(c1));
         	log.info("Preloading "+customerRepository.save(cus1));
		};
	}



}
