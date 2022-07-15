//package ch.sst.Shop;
//
//
//import ch.sst.Shop.model.Cart;
//import ch.sst.Shop.model.Customer;
//import ch.sst.Shop.model.Producer;
//import ch.sst.Shop.model.Product;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ch.sst.Shop.repository.*;
//
//import java.util.Date;
//
//@Configuration
//public class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(CustomerRepository customerRepository, ProducerRepository producerRepository, CartRepository cartRepository, ProductRepository productRepository){
//        return args -> {
//
//            log.info("guguseli");
//
//           Producer pro1 = new Producer("Nestle", "Pionierstrasse 1", "Winterthur",8400,"Switzerland","+41 12 345 67 89","zuckerfrei@nestle.cn");
//            producerRepository.save(pro1);
//           //          log.info("Preloading "+producerRepository.save(new Producer("Nestle", "Pionierstrasse 1", "Winterthur",8400,"Switzerland","+41 12 345 67 89","zuckerfrei@nestle.cn")));
////            log.info("Preloading "+productRepository.save(new Product("Fuze Tea","Gesunder Eistee auf Schwarzteebasis",9.99,100,"Nix gut diese",producerRepository.getReferenceById(1L))));
//  //          log.info("Preloading "+customerRepository.save(new Customer("Peter", "Lustig","peter.lustig@blume.de","LeterPustig",new Date(),"Bahnhofstrasse 1","Zürich",8000,"Switzerland")));
//    //        log.info("Preloading "+cartRepository.save(new Cart(0.00,customerRepository.getReferenceById((long)1))));
//        };
//    }
//}
