package ch.sst.Shop.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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







}
