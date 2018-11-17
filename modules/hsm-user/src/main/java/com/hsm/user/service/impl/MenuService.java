package com.hsm.user.service.impl;

import com.framework.common.domain.TreeModel;
import com.framework.core.util.TreeModelSupport;
import com.hsm.pay.common.em.MenuType;
import com.hsm.user.model.model.SysMenu;
import com.hsm.user.repository.MenuRepository;
import com.hsm.user.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {
    @Autowired
    MenuRepository menuRepository;

    /**
     * 获取菜单树
     * @return 返回树形菜单
     */
    @Override
    public TreeModel<SysMenu> listTree() {
        TreeModelSupport support = TreeModelSupport.getInstance();
        List<SysMenu> menuList = menuRepository.findByType(MenuType.menu.toString());
        TreeModel<SysMenu> tree = support.sortTreeModel(menuList);
        return tree;
    }
}
