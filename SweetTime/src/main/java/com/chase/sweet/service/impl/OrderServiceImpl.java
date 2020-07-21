package com.chase.sweet.service.impl;

import com.chase.sweet.entity.Order;
import com.chase.sweet.mapper.OrderMapper;
import com.chase.sweet.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chase
 * @since 2020-07-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
