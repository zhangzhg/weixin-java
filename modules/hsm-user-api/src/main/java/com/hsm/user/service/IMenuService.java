package com.hsm.user.service;

import com.framework.common.domain.TreeModel;
import com.hsm.user.model.model.SysMenu;

public interface IMenuService {
    TreeModel<SysMenu> listTree();
}
