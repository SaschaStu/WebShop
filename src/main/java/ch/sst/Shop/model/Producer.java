package ch.sst.Shop.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Producer")
public class Producer {

    @Id
    @GeneratedValue
    long id;

    String name;

    String street;

    String city;

    int zip;

    String country;

    int phoneNumber;

    String email;

    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)
    List<Product> productList;





}
