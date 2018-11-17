package com.hsm.user.controller;


import com.framework.common.domain.ResultData;
import com.framework.common.domain.TreeModel;
import com.hsm.user.model.model.SysMenu;
import com.hsm.user.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    IMenuService menuService;

    /**
     * 获取菜单
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResultData list() {
        ResultData result = new ResultData();
        TreeModel<SysMenu> tree =  menuService.listTree();
        result.put("tree", tree);
        return result;
    }
}
