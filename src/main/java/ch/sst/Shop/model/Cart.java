package ch.sst.Shop.model;


import javax.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue
    long id;

    double totalPrice;


    @OneToOne(mappedBy = "cart")
    Customer customer;
}