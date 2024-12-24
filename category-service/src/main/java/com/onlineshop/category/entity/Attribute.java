package com.onlineshop.category.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Attribute {
    private String name;
    private String value;
}
