package com.imooc.service.impl;

import com.imooc.bean.Area;
import com.imooc.dao.AreaDao;
import com.imooc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by rj on 18/2/27.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        int a = 1/0;
        return areaDao.queryAreaById(areaId);
    }

    //Transactional 默认只回滚RuntimeException类的异常,若要在抛出其他异常信息时进行事务的回滚,则需要设置rollbackFor
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean insertArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.insertArea(area);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean updateArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("修改区域信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("修改区域信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean deleteArea(Area area) {
        if(area.getAreaId() != null ){
            try{
                int effectedNum = areaDao.deleteArea(area);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空!");
        }
    }
}
