package com.dulp.xyz.common.access;

import com.dulp.xyz.common.redis.RedisPoolUtil;
import com.dulp.xyz.common.result.CodeMsg;
import com.dulp.xyz.common.util.CookieUtil;
import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.common.util.JsonUtil;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.serivce.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Service
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            User user = getUser(request, response);
            UserContext.setUser(user);
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            boolean needLogin = accessLimit.needLogin();
            String key = request.getRequestURI();
            if (needLogin) {
                if (user == null) {
                    render(response, CodeMsg.SESSION_ERROR);
                    return false;
                }
            }
        }
        return true;
    }

    private void render(HttpServletResponse response, CodeMsg codeMsg) throws Exception {
        response.reset();//geelynote 这里要添加reset，否则报异常 getWriter() has already been called for this response.
        response.setCharacterEncoding("UTF-8");//geelynote 这里要设置编码，否则会乱码
        response.setContentType("application/json;charset=UTF-8");//geelynote 这里要设置返回值的类型，因为全部是json接口。
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.obj2String(IMoocJSONResult.error(codeMsg)));
        out.flush();
        out.close();//geelynote 这里要关闭
    }

    private User getUser(HttpServletRequest request, HttpServletResponse response) {
        String paramToken = request.getParameter(CookieUtil.COOKIE_NAME);
        String cookieToken = CookieUtil.getCookieValue(request, CookieUtil.COOKIE_NAME);
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return null;
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        String userstr = RedisPoolUtil.get(token);
        User user = JsonUtil.string2Obj(userstr, User.class);
        //延长有效期
        if (user != null) {
            CookieUtil.writeLoginToken(response, token, user);
        }
        return user;
    }

}
