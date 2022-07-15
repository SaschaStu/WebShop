package ch.sst.Shop.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue
    long id;

    double totalPrice;

    @JsonBackReference
    @OneToOne(mappedBy = "cart")
    Customer customer;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "Cart_Product",joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> productList;

    public Cart( double totalPrice) {
        super();
        this.totalPrice = totalPrice;
    }
    public Cart( double totalPrice, Product product) {
        super();
        this.totalPrice = totalPrice;
        productList.add(product);
    }

    public Cart() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", productSet=" + productList +
                '}';
    }
}