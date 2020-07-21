package com.chase.sweet.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chase.sweet.entity.MilkTea;
import com.chase.sweet.entity.MilkTeaVO;
import com.chase.sweet.service.MilkTeaService;
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
@RequestMapping("/milktea")
public class MilkteaController {

    @Resource
    private MilkTeaService milkTeaService;

    @GetMapping("/getOne/{id}")
    public MilkTea getOne(@PathVariable("id") Integer id){
        return milkTeaService.lambdaQuery().eq(MilkTea::getId, id).one();
    }

    @GetMapping("/getAllByType/{offset}/{limit}/{type}")
    public MilkTeaVO getAllByType(@PathVariable("offset") int offset, @PathVariable("limit") int limit, @PathVariable("type") int type) {
        Page<MilkTea> page = new Page<>(offset, limit);
        IPage<MilkTea> iPage = milkTeaService.lambdaQuery().eq(MilkTea::getType, type).page(page);
        MilkTeaVO milkTeaVO = new MilkTeaVO();
        milkTeaVO.setRecords(iPage.getRecords());
        milkTeaVO.setTotal(iPage.getTotal());
        return milkTeaVO;
    }

    @GetMapping("/getAll")
    public MilkTeaVO getAll() {
        MilkTeaVO milkTeaVO = new MilkTeaVO();
        milkTeaVO.setRecords(milkTeaService.list());
        milkTeaVO.setTotal((long) milkTeaService.list().size());
        return milkTeaVO;
    }

    @DeleteMapping("/deleteByIds")
    public String deleteByIds(@RequestBody List<Integer> ids) {
        boolean result = milkTeaService.removeByIds(ids);
        return result ? "success" : "failure";
    }

    @PostMapping("/save")
    public String save(@RequestBody MilkTea milkTea) {
        boolean result = milkTeaService.save(milkTea);
        return result ? "success" : "failure";
    }
}

