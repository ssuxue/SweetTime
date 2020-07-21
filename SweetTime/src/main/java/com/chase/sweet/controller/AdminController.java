package com.chase.sweet.controller;


import com.chase.sweet.entity.Admin;
import com.chase.sweet.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chase
 * @since 2020-07-17
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("/getImgPath/{id}")
    public String getImgPath(@PathVariable("id") Integer id) {
        Admin admin = adminService.getById(id);
        return admin.getImgPath();
    }
}

