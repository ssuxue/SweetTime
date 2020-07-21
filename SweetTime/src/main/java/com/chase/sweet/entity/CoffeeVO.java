package com.chase.sweet.entity;

import lombok.Data;

import java.util.List;

/**
 * @author chase
 */
@Data
public class CoffeeVO {
    private List<Coffee> records;
    private Long total;
}
