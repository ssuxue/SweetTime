package com.chase.sweet.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chase.sweet.entity.Coffee;
import com.chase.sweet.entity.CoffeeVO;
import com.chase.sweet.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chase
 * @since 2020-07-17
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Resource
    private CoffeeService coffeeService;

    @GetMapping("/getOne/{id}")
    public Coffee getOne(@PathVariable("id") Integer id) {
        return coffeeService.getOne(new QueryWrapper<Coffee>().eq("id", id), false);
    }

    @GetMapping("/getAllByType/{type}")
    public List<Coffee> getAllByType(@PathVariable("type") Integer type) {
        List<Coffee> list = coffeeService.lambdaQuery()
                .eq(Coffee::getType, type)
                .list();
        return list;
    }

    @PostMapping("/save")
    public String save(@RequestBody Coffee coffee) {
        boolean result = coffeeService.save(coffee);
        return result ? "success" : "failure";
    }

    @PutMapping("/update")
    public String update(@RequestBody Coffee coffee) {
        boolean result = coffeeService.lambdaUpdate()
                .eq(Coffee::getId, coffee.getId())
                .set(Coffee::getName, coffee.getName())
                .set(Coffee::getPrice, coffee.getPrice())
                .set(Coffee::getType, coffee.getType())
                .update();
        return result ? "success" : "failure";
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean result = coffeeService.lambdaUpdate()
                .eq(Coffee::getId, id)
                .remove();
        return result ? "success" : "failure";
    }

    @DeleteMapping("/deleteByIds")
    public void deleteByIds() {

    }

    @GetMapping("/getCoffeeByType/{offset}/{limit}/{type}")
    public CoffeeVO getCoffeeByType(@PathVariable("offset") int offset, @PathVariable("limit") int limit, @PathVariable("type") int type) {
        Page<Coffee> page = new Page<>(offset, limit);
        IPage<Coffee> iPage = coffeeService.lambdaQuery().eq(Coffee::getType, type).page(page);
        CoffeeVO coffeeVO = new CoffeeVO();
        coffeeVO.setRecords(iPage.getRecords());
        coffeeVO.setTotal(iPage.getTotal());
        return coffeeVO;
    }

}

