package com.hsm.user.service.impl;

import com.framework.core.exception.BusinessException;
import com.framework.user.auth.BaseUsernamePasswordToken;
import com.framework.user.model.SysUserEntity;
import com.hsm.user.model.model.SysUser;
import com.hsm.user.repository.UserRepository;
import com.hsm.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public SysUser login(String username, String password) {
        BaseUsernamePasswordToken token = new BaseUsernamePasswordToken(username, password);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            SysUserEntity userInfo = (SysUserEntity) subject.getPrincipal();
            return userRepository.findOne(userInfo.getId());
        } catch (Exception ex) {
            throw new BusinessException("用户名或密码错误");
        }
    }

    @Override
    public Page<SysUser> list(PageRequest pageable, String name) {
        SysUser user = new SysUser();
        if (StringUtils.isNotBlank(name)) {
            user.setName(name);
        }

        return userRepository.find(user, pageable);
    }

}
