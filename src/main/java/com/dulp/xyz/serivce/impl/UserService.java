package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.common.exception.GlobalException;
import com.dulp.xyz.common.org.n3r.idworker.Sid;
import com.dulp.xyz.common.util.*;
import com.dulp.xyz.mapper.UserMapper;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.VO.LoginVO;
import com.dulp.xyz.serivce.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public IMoocJSONResult login(HttpServletRequest request, HttpServletResponse response, LoginVO loginVo) {
        String username = loginVo.getUsername();
        String formPass = loginVo.getPassword();
        //验证密码
        String password = MD5Utils.getMD5Str(formPass);
        User user = userMapper.selectLogin(username, password);
        if (user == null) {
            throw new GlobalException("用户名或密码错误");
        }
        //生成cookie
        String token = user.getId();
        CookieUtil.writeLoginToken(response, token, user);
        user.setPassword(StringUtils.EMPTY);
        return IMoocJSONResult.ok(user);
    }

    @Override
    public IMoocJSONResult register(User user) {
        int resultCount = userMapper.checkUsername(user.getUsername());
        if (resultCount > 0) {
            throw new GlobalException("用户名已存在");
        }
        user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        user.setId(Sid.nextShort());
        int cnt = userMapper.insert(user);
        if (cnt == 0) {
            throw new GlobalException("注册插入数据库失败");
        }
        return IMoocJSONResult.ok("注册成功");
    }
}
