package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.common.org.n3r.idworker.Sid;
import com.dulp.xyz.common.storage.QiniuStorage;
import com.dulp.xyz.mapper.TAuthUserMapper;
import com.dulp.xyz.pojo.TAuthUser;
import com.dulp.xyz.serivce.TAuthUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TAuthUserServiceImpl implements TAuthUserService {
   @Autowired
   private TAuthUserMapper tAuthUserMapper;

   @Autowired
   private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String realname) {
        TAuthUser tAuthUser = new TAuthUser();
        tAuthUser.setRealname(realname);
        TAuthUser result = tAuthUserMapper.selectOne(tAuthUser);
        return result == null? false : true;
    }
    //操作级别
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(TAuthUser tAuthUser) {
        String userId = sid.nextShort();
        tAuthUser.setId(userId);
        tAuthUserMapper.insert(tAuthUser);
    }

    @Override
    public TAuthUser queryUserForLogin(String realname, String password) {
        Example userExample = new Example(TAuthUser.class);
        Example.Criteria criteria =userExample.createCriteria();
        criteria.andEqualTo("realname",realname);
        criteria.andEqualTo("password",password);
        TAuthUser result = tAuthUserMapper.selectOneByExample(userExample);


        return result;
    }

    @Override
    public List<TAuthUser> queryRecomd() {
        List<TAuthUser> recomdList = tAuthUserMapper.queryRecomd();
        if(CollectionUtils.isNotEmpty(recomdList)){
            for(TAuthUser item : recomdList){
                if(StringUtils.isNotEmpty(item.getHeader())){
                    item.setHeader(item.getHeader());
                }
            }
        }
        return recomdList;
    }

    @Override
    public TAuthUser getByUsername(String username) {
        return tAuthUserMapper.getByUsername(username);
    }
}
