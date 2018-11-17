package com.hsm.user.repository;

import com.framework.core.repository.BaseJpaRepository;
import com.hsm.user.model.model.SysMenu;

import java.util.List;

public interface MenuRepository extends BaseJpaRepository<SysMenu, String> {
    List<SysMenu> findByType(String type);
}
