package ch.sst.Shop.model;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue
    long id;


    String firstname;

    String lastname;

    String email;

    String password;

    Date registerDate;

    String street;

    String city;

    int zip;

    String country;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    Cart cart;



}
