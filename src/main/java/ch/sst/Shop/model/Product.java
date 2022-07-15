package ch.sst.Shop.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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




}
