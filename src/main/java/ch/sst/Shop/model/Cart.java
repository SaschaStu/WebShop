package ch.sst.Shop.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue
    long id;

    double totalPrice;


    @OneToOne(mappedBy = "cart")
    Customer customer;

    @ManyToMany
    Set<Product> productSet;
}