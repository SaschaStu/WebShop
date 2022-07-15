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


    @ManyToMany(mappedBy = "productSet")
    Set<Cart> cartSet;


    public Product(long id, String shortname, String name, double price, int stock, String specifications, Producer producer) {
        this.id = id;
        this.shortname = shortname;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.specifications = specifications;
        this.producer = producer;
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

    public Set<Cart> getCartSet() {
        return cartSet;
    }

    public void setCartSet(Set<Cart> cartSet) {
        this.cartSet = cartSet;
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
                ", cartSet=" + cartSet +
                '}';
    }
}
