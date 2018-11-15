package com.hsm.user.service;


import com.hsm.user.model.model.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IUserService {
    SysUser login(String username, String password);

    Page<SysUser> list(PageRequest pageable, String name);
}
