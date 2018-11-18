package com.dulp.xyz.serivce;

import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.VO.LoginVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {

    IMoocJSONResult login(HttpServletRequest request, HttpServletResponse response, LoginVO loginVo);

    IMoocJSONResult register(User user);

}
