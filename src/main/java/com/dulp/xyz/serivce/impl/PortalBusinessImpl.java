package com.dulp.xyz.serivce.impl;


import com.dulp.xyz.pojo.TConstsClassify;
import com.dulp.xyz.pojo.VO.ConstsClassifyVO;
import com.dulp.xyz.serivce.IConstsClassifyService;
import com.dulp.xyz.serivce.IPortalBusiness;
import com.dulp.xyz.serivce.TCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class PortalBusinessImpl implements IPortalBusiness {
    @Autowired
    private TCourseService courseService;
    @Autowired
    private IConstsClassifyService iConstsClassifyService;
    @Override
    public Map<String, ConstsClassifyVO> queryAllClassifyMap(){
        Map<String,ConstsClassifyVO> resultMap = new LinkedHashMap<>();
        Iterator<TConstsClassify> it =iConstsClassifyService.queryAll().iterator();
        while(it.hasNext()){
            TConstsClassify c = it.next();
            if("0".equals(c.getParentCode())){
                ConstsClassifyVO vo = new ConstsClassifyVO();
                BeanUtils.copyProperties(c,vo);
                resultMap.put(vo.getCode(), vo);
            }else{//二级分类
                if(null != resultMap.get(c.getParentCode())){
                    resultMap.get(c.getParentCode()).getSubClassifyList().add(c);//添加到子分类中
                }
            }
        }
        return resultMap;
    }
}
