package com.imooc.dao;

import com.imooc.bean.Area;

import java.util.List;

/**
 * Created by rj on 18/2/27.
 */
public interface AreaDao {
    List<Area> queryArea();

    Area queryAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(Area area);
}
