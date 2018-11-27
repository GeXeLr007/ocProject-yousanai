package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.TAuthUser;
import com.dulp.xyz.utils.MyMapper;

import java.util.List;

public interface TAuthUserMapper extends MyMapper<TAuthUser> {

    /*
     * 加载讲师
     *
     * */

    public List<TAuthUser> queryRecomd();
    public TAuthUser getByUsername(String username);
    public TAuthUser getById(Integer teacherId);
}
