package com.hsm.user.service.impl;

import com.framework.common.constants.ErrorCode;
import com.framework.core.exception.BusinessException;
import com.framework.user.auth.BaseUsernamePasswordToken;
import com.framework.user.model.SysUserEntity;
import com.hsm.pay.common.constant.AppConst;
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
import org.springframework.util.ObjectUtils;

import java.util.List;


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

    @Override
    public void save(SysUser user) {
        if (StringUtils.isNotBlank(user.getId())) {
            SysUser us = userRepository.findOne(user.getId());
            if (StringUtils.isBlank(user.getPassword())) {
                //修改属性
                us.setName(user.getName());
                us.setPhone(user.getPhone());
                us.setQq(user.getQq());
                us.setStatus(user.getStatus());
                us.setWechatNo(user.getWechatNo());
            } else {
                //修改密码
                us.setPassword(user.getPassword());
            }

            userRepository.save(us);
        } else {
            //新增
            //验证
            SysUser us = new SysUser();
            us.setName(user.getName());

            List<SysUser> userList = userRepository.find(us);
            if (!ObjectUtils.isEmpty(userList)) {
                throw new BusinessException("用户名已存在");
            }

            us.setName(null);
            us.setAccount(user.getAccount());
            userList = userRepository.find(us);
            if (!ObjectUtils.isEmpty(userList)) {
                throw new BusinessException("账户名已存在");
            }

            //默认密码 888888
            user.setPassword(AppConst.DEFAULT_PASSWORD);
            userRepository.save(user);
        }
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

}
