package dev.felipeazsantos.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String name;

    private String cep;

    public Customer() {
    }

    public Customer(String cpf, String name, String cep) {
        this.cpf = cpf;
        this.name = name;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
