package com.stock_manager.stock_manager.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String cep;
    private String street;
    private String city;
    private String neighborhood;
    private Integer number;
    private String complement;

    private LocalDateTime updateAt;
    private LocalDateTime createAt;
    private LocalDateTime deleteAt;

    private Boolean isActive;

    @ManyToOne
    private Supplier supplier;


    
    public Address(String cep, String street, String city, String neighborhood, Integer number, String complement,
    Supplier supplier) {
        
        this.cep = cep;
        this.street = street;
        this.city = city;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
        this.supplier = supplier;

        this.updateAt = LocalDateTime.now();
        this.createAt = LocalDateTime.now();
        this.deleteAt = LocalDateTime.now();

        this.isActive = true;

    }

    public Address() {
    }

}
