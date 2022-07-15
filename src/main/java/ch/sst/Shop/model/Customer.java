package ch.sst.Shop.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    Cart cart;


    public Customer( String firstname, String lastname, String email, String password, Date registerDate, String street, String city, int zip, String country) {
       super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    public Customer( String firstname, String lastname, String email, String password, Date registerDate, String street, String city, int zip, String country, Cart cart) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.cart = cart;
    }

    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", country='" + country + '\'' +
                ", cart=" + cart +
                '}';
    }
}
