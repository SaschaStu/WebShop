package ch.sst.Shop.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
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

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    Producer producer;


    @JsonBackReference
    @ManyToMany(mappedBy = "productList")
    List<Cart> cartList;


    public Product( String shortname, String name, double price, int stock, String specifications, Producer producer) {
        super();
        this.shortname = shortname;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.specifications = specifications;
        this.producer = producer;
    }

    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", shortname='" + shortname + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", specifications='" + specifications + '\'' +
                ", producer=" + producer +
                ", cartSet=" + cartList +
                '}';
    }
}
