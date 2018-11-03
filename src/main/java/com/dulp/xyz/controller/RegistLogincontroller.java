package com.dulp.xyz.controller;


import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.common.util.MD5Utils;
import com.dulp.xyz.pojo.TAuthUser;
import com.dulp.xyz.pojo.VO.TAuthUserVO;
import com.dulp.xyz.serivce.TAuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@RestController
@Api(value = "用户注册接口",tags = {"注册登录的接口"})
public class RegistLogincontroller extends BastisController{
    @Autowired
    private TAuthUserService tAuthUserService;


    @ApiOperation(value = "用户注册接口",notes = "用户注册")
    @PostMapping("/regist")
    public IMoocJSONResult regist(@RequestBody TAuthUser tAuthUser) throws Exception {
        // 1.判断用户名和密码不为空
//        if(StringUtils.isBlank(tAuthUser.getRealname())||StringUtils.isBlank(tAuthUser.getPassword())){
//            return IMoocJSONResult.errorMsg("用户名与密码不能为空");
//        }
        //2.判断用户名是否存在
        boolean usernameIsExist = tAuthUserService.queryUsernameIsExist(tAuthUser.getRealname());
        //3.保存用户信息
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        if(!usernameIsExist){
            tAuthUser.setRealname(tAuthUser.getRealname());
            tAuthUser.setPassword(MD5Utils.getMD5Str(tAuthUser.getPassword()));
            tAuthUser.setCity("北京");
            tAuthUser.setDistrict("北京");
            tAuthUser.setUsername(tAuthUser.getRealname());
            tAuthUser.setGender(true);
            tAuthUser.setCertNo("");
            tAuthUser.setCollegeName("北京大学");
            tAuthUser.setHeader("");
            tAuthUser.setMobile("");
            tAuthUser.setStatus(true);
            tAuthUser.setBirthday(date);
            tAuthUser.setEducation("本科");
            tAuthUser.setCollegeCode("");
            tAuthUser.setTitle("");
            tAuthUser.setSign("");
            tAuthUser.setOpenId("无");
            tAuthUser.setWechatId("123");
            tAuthUser.setQq("123");
            tAuthUser.setLoginTime(date);
            tAuthUser.setIp("123");
            tAuthUser.setProvince("123");
            tAuthUser.setCity("123");
            tAuthUser.setDistrict("123");
            tAuthUser.setWeight(123);
            tAuthUser.setCreateTime(date);
            tAuthUser.setCreateUser("123");
            tAuthUser.setUpdateTime(date);
            tAuthUser.setUpdateUser("123");
            tAuthUser.setDel(true);

            tAuthUserService.saveUser(tAuthUser);
        }else {
            return IMoocJSONResult.errorMsg("用户已存在");
        }
        tAuthUser.setPassword("");
        TAuthUserVO tAuthUserVO = setUserRedisSessionTocken(tAuthUser);
        return IMoocJSONResult.ok(tAuthUserVO);
    }
    @ApiOperation(value ="用户登录接口" ,notes = "用户登录")
    @PostMapping("/login")
    public IMoocJSONResult login(@RequestBody TAuthUser tAuthUser) throws Exception {
        //1.判断用户名密码是否存在
        String realname = tAuthUser.getRealname();
        String password = tAuthUser.getPassword();
        if(StringUtils.isBlank(realname)||StringUtils.isBlank(password)){
            return IMoocJSONResult.ok("用户名密码不能为空");
        }
        //2.判断用户名密码不能为空
        TAuthUser userResult = tAuthUserService.queryUserForLogin(realname,MD5Utils.getMD5Str(tAuthUser.getPassword()));
        //3.判断密码
        if(userResult != null){
            userResult.setPassword("");
            TAuthUserVO tAuthUserVO = setUserRedisSessionTocken(userResult);
            return IMoocJSONResult.ok(tAuthUserVO);
        }else {
            return IMoocJSONResult.errorMsg("用户名或者密码错误,请重试....");
        }

    }

    public TAuthUserVO setUserRedisSessionTocken(TAuthUser tAuthUserModel){
        String uniqueToken = UUID.randomUUID().toString();
        redisOperator.set(USER_REDIS_SESSION+":"+tAuthUserModel.getId(),uniqueToken,1000*60*30);
        TAuthUserVO tAuthUserVO = new TAuthUserVO();
        BeanUtils.copyProperties(tAuthUserModel,tAuthUserModel);
        tAuthUserVO.setUserToken(uniqueToken);
        return tAuthUserVO;
    }

}
