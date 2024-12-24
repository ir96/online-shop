package com.onlineshop.category.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Data
public class Price {
    private String currency;
    private BigDecimal amount;
}
