package com.stock_manager.stock_manager.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seller {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "seller")
    private List<Sell> sells;

    private LocalDateTime updateAt;
    private LocalDateTime createAt;
    private LocalDateTime deleteAt;

    private Boolean isActive;

    public Seller() {
    }

    public Seller(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        this.uuid = UUID.randomUUID();
        this.updateAt = LocalDateTime.now();
        this.createAt = LocalDateTime.now();
        this.deleteAt = LocalDateTime.now();
        this.isActive = true;
    }    
}
