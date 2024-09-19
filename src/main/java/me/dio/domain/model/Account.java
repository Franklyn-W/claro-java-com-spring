package me.dio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // indica que a coluna number da tabela tb_account é do tipo unique, não devendo aceitar repetição
    private String number;

    private String agency;
    
    @Column(scale = 2, precision = 13) // define que a coluna terá 2 casas decimais e um total de 13 numeros (11 interiros e 2 decimais)
    private BigDecimal balance;

    @Column(name = "additional_limit", scale = 2, precision = 13) // alterado nome da coluna, pois a palavra limit, pode ser uma palavra reservada
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}
