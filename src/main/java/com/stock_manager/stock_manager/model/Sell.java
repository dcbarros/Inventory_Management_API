package com.stock_manager.stock_manager.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.stock_manager.stock_manager.model.enums.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    @ManyToOne
    private Seller seller;

    @OneToMany(mappedBy = "sell")
    private List<Item> itens;

    private PaymentType paymentType;

    private LocalDateTime createAt;
    
    private Boolean pay;
    
    public Sell() {
    }

    public Sell(Seller seller, PaymentType paymentType) {
        this.seller = seller;
        this.paymentType = paymentType;

        this.pay = false;
        this.createAt = LocalDateTime.now();
        this.itens = new ArrayList<>();
    }

    public BigDecimal subtotal() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : itens) {
            sum = sum.add(item.subtotal());
        }
        return sum;
    }
}

