package com.management.controller;

import com.management.model.ov.Result;
import com.management.service.AdminService;
import com.management.service.ExpertService;
import com.management.tools.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 业务员controller
 * @author: ggmr
 * @create: 2018-08-15 15:12
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
@Api(value = "AdminService对应的controller")
public class AdminController {
    @Resource
    @ApiParam("和专家相关的业务操作")
    private AdminService adminService;

    @GetMapping("/allProjectCategory")
    @ApiOperation(value = "查一个业务员负责的所有的项目大类", notes = "根据业务员工号查找他负责的所有的项目大类")
    public Result findProjectCategoryInfo(@RequestHeader(value = "Authorization")String token) {
        String userId = JwtUtil.parseJwt(token);
        return adminService.someoneAllProjectCategory(userId);
    }
}