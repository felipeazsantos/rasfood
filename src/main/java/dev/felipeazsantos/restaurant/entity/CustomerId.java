package dev.felipeazsantos.restaurant.entity;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerId {

    private String email;
    private String cpf;

    public CustomerId() {
    }

    public CustomerId(String email, String cpf) {
        this.email = email;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
