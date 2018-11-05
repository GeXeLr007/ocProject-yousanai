package com.dulp.xyz.controller;

import com.dulp.xyz.common.exception.GlobalException;
import com.dulp.xyz.common.util.HttpClientUtil;
import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.VO.LoginVo;
import com.dulp.xyz.serivce.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${weixin.app_id}") // spring配置文件配置了appID
    private String appId;

    @Value("${weixin.app_secret}") // spring配置文件配置了secret
    private String secret;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/register")
    public IMoocJSONResult register(@Valid User user) {
        return userService.register(user);
    }

    @RequestMapping("/login")
    public IMoocJSONResult doLogin(HttpServletRequest request, HttpServletResponse response, @Valid LoginVo loginVo) {
        //登录
        return userService.login(request, response, loginVo);
    }

    @RequestMapping("/openId")
    public IMoocJSONResult openId(String code) throws JSONException { // 小程序端获取的CODE
        boolean check = StringUtils.isEmpty(code);
        if (check) {
            throw new GlobalException("获取openId,code参数异常");
        }
        StringBuilder urlPath = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session"); // 微信提供的API，这里最好也放在配置文件
        urlPath.append(String.format("?appid=%s", appId));
        urlPath.append(String.format("&secret=%s", secret));
        urlPath.append(String.format("&js_code=%s", code));
        urlPath.append(String.format("&grant_type=%s", "authorization_code")); // 固定值
        String data = HttpClientUtil.get(urlPath.toString(), null, null); // java的网络请求，这里是我自己封装的一个工具包，返回字符串
        System.out.println("请求结果：" + data);
        String openId = null;
        openId = new JSONObject(data).getString("openid");
        System.out.println("获得openId: " + openId);
        return IMoocJSONResult.ok(openId);

    }
}
