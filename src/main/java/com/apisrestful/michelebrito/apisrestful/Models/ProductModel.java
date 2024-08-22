package com.apisrestful.michelebrito.apisrestful.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="products")
public class ProductModel{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idProUuid;
    private String name;
    private BigDecimal value;

    public UUID getIdProUuid() {
        return idProUuid;
    }
    public void setIdProUuid(UUID idProUuid) {
        this.idProUuid = idProUuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
}