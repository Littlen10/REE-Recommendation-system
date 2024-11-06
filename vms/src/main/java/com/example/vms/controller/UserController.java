package com.example.vms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vms.common.QueryPagePara;
import com.example.vms.common.Result;
import com.example.vms.entity.User;
import com.example.vms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vms
 * @since 2024-11-05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /*@GetMapping
    public String hello() {
        return "Hello vms";
    }*/
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    //增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
    //改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //删
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
    //查（模糊，匹配）
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //lambdaQueryWrapper.eq(User::getName, user.getName()); 完全匹配
        lambdaQueryWrapper.like(User::getName, user.getName());
        return userService.list(lambdaQueryWrapper);}

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPagePara params) {
        HashMap elements = params.getParams();
        String name = (String) elements.get("name");
        /*System.out.println("name=="+elements.get("name"));
        System.out.println("no=="+elements.get("no"));*/

        Page<User> page = new Page<>(params.getPageNum(),params.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

        IPage iPage = userService.page(page, lambdaQueryWrapper);
        System.out.println("total=="+iPage.getTotal());
        return iPage.getRecords();
    }

    @PostMapping("/listPages")
    public Result listPages(@RequestBody QueryPagePara params) {
        HashMap elements = params.getParams();
        String name = (String) elements.get("name");

        Page<User> page = new Page<>(params.getPageNum(),params.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

        IPage iPage = userService.page(page, lambdaQueryWrapper);
        System.out.println("total=="+iPage.getTotal());
        return  Result.success(iPage.getRecords(),iPage.getTotal());
    }
}
