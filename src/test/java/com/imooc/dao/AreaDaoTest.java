package com.imooc.dao;

import com.imooc.bean.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rj on 18/2/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() throws Exception {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() throws Exception {
        Area area  = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updateArea() throws Exception {
        Area area  = new Area();
        area.setAreaName("西苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void deleteArea() throws Exception {
        Area area  = new Area();
        area.setAreaId(3);
        int effectedNum = areaDao.deleteArea(area);
        assertEquals(1,effectedNum);
    }

}