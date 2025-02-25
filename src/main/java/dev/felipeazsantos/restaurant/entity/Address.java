package dev.felipeazsantos.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String uf;

    private String city;

    private String quarter;

    private String complement;

    private String cep;

    @ManyToOne
    private Customer customer;

    public Address() {
    }

    public Address(String street, String uf, String city, String quarter, String complement, String cep) {
        this.street = street;
        this.uf = uf;
        this.city = city;
        this.quarter = quarter;
        this.complement = complement;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", uf='" + uf + '\'' +
                ", city='" + city + '\'' +
                ", quarter='" + quarter + '\'' +
                ", complement='" + complement + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
