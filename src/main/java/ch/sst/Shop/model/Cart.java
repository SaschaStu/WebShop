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
    @JoinTable(name = "Cart_Product",joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> productSet;

    public Cart( double totalPrice, Customer customer) {
        super();
        this.totalPrice = totalPrice;
        this.customer = customer;
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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", productSet=" + productSet +
                '}';
    }
}