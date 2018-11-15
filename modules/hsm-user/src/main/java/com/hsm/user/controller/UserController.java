package com.hsm.user.controller;

import com.framework.common.domain.ResultData;
import com.framework.core.exception.BusinessException;
import com.hsm.pay.common.model.PageResult;
import com.hsm.user.model.model.SysUser;
import com.hsm.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    //@RequiresPermissions("role:oper")
    //@RequiresRoles("role")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public ResultData list(int page, int size, String name) {
        ResultData result = new ResultData();
        result.put("success", true);
        try {
            PageRequest pageable = new PageRequest(page-1, size);
            Page<SysUser> users = userService.list(pageable, name);
            PageResult pageResult = new PageResult(users.getContent(), users.getTotalElements(), size, page);
            result.put("pageResult", pageResult);
        } catch (BusinessException e) {
            result.put("success", false);
            result.put("msg", e.getMsg());
        }

        return result;
    }
}