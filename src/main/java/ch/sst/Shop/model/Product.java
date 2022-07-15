package ch.sst.Shop.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue
    long id;

    String shortname;

    String name;

    double price;

    int stock;

    String specifications;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    Producer producer;


    @ManyToMany
    Set<Cart> cartSet;


}
