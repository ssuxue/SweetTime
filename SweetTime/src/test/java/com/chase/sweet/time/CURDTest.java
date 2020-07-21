package com.chase.sweet.time;

import com.chase.sweet.entity.Admin;
import com.chase.sweet.entity.Coffee;
import com.chase.sweet.entity.MilkTea;
import com.chase.sweet.service.AdminService;
import com.chase.sweet.service.CoffeeService;
import com.chase.sweet.service.MilkTeaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CURDTest {

    @Resource
    private CoffeeService coffeeService;
    @Resource
   private MilkTeaService milkTeaService;
    @Resource
   private AdminService adminService;

    @Test
    public void save() {
        Coffee coffee = new Coffee();
        coffee.setName("英式咖啡");
        coffee.setPrice(22.0);
        coffee.setType(2);
        boolean result = coffeeService.save(coffee);
        System.out.println(result);
    }

    @Test
    public void update() {
        boolean update = coffeeService.lambdaUpdate()
                .eq(Coffee::getId, 13)
                .set(Coffee::getName, "日式咖啡").set(Coffee::getPrice, 22.5)
                .update();
        System.out.println(update);
    }

    @Test
    public void delete() {
        boolean result = coffeeService.lambdaUpdate()
                .eq(Coffee::getId, 14)
                .remove();
        System.out.println(result);
    }

    @Test
    public void getOne(){
        MilkTea milkTea =  milkTeaService.lambdaQuery().eq(MilkTea::getId, 1).one();
        System.out.println(milkTea);
    }

    @Test
    public void deleteById() {
        milkTeaService.removeById(48);
    }

    @Test
    public void deleteByIds() {
        List<Integer> ids = Arrays.asList(47, 48);
        boolean result = milkTeaService.removeByIds(ids);
        System.out.println("------" + result + "======");
    }

    @Test
    public void getImgPath() {
        Admin admin = adminService.getById(1101);
        System.out.println(admin.getImgPath());
    }

}
