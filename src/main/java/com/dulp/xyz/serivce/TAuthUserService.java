package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.TAuthUser;

import java.util.List;

public interface TAuthUserService {
    public boolean queryUsernameIsExist(String realname);
    /*
     * 保存用户对象
     *
     * */
    public void saveUser(TAuthUser tAuthUser);
    /**
     * 查询用户是否存在
     * */
    public TAuthUser queryUserForLogin(String realname,String password);
    /*
    * 加载讲师
    *
    * */
    public List<TAuthUser> queryRecomd();
    /**
     *根据username获取
     **/
    public TAuthUser getByUsername(String username);
}
