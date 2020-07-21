package com.chase.sweet.service.impl;

import com.chase.sweet.entity.Admin;
import com.chase.sweet.mapper.AdminMapper;
import com.chase.sweet.service.AdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
