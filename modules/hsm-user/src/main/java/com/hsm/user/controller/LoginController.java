package com.hsm.user.controller;


import com.framework.common.domain.ResultData;
import com.framework.common.util.UUIDUtils;
import com.framework.core.exception.BusinessException;
import com.framework.user.auth.TokenFormAuthenticationFilter;
import com.hsm.user.model.dto.LoginDto;
import com.hsm.user.model.model.SysUser;
import com.hsm.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultData login(LoginDto login) {
        ResultData result = new ResultData();
        result.put("success", true);
        try {
            SysUser user = userService.login(login.getUsername(), login.getPassword());
            String token = UUIDUtils.generate();

            String tokenKey = TokenFormAuthenticationFilter.tokenKey;
            List<String> list = (List<String>) redisTemplate.opsForValue().get(tokenKey);
            if (ObjectUtils.isEmpty(list)) {
                list = new ArrayList<>();
            }

            list.add(token);
            redisTemplate.opsForValue().set(tokenKey, list, 3600*24, TimeUnit.SECONDS);

            result.put("token", token);
            result.put("user", user);
        } catch (BusinessException e) {
            result.put("msg", e.getMsg());
            result.put("success", false);
        }

        return result;
    }
}
