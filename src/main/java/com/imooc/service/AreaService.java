package com.imooc.service;

import com.imooc.bean.Area;
import com.imooc.dao.AreaDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by rj on 18/2/27.
 */
public interface AreaService {
    List<Area> queryArea();

    Area queryAreaById(int areaId);

    boolean insertArea(Area area);

    boolean updateArea(Area area);

    boolean deleteArea(Area area);



}
