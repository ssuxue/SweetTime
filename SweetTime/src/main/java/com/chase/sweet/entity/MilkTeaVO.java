package com.chase.sweet.entity;

import lombok.Data;

import java.util.List;

/**
 * @author chase
 */
@Data
public class MilkTeaVO {
    private List<MilkTea> records;
    private Long total;
}
