package com.imooc.controller;

import com.imooc.bean.Area;
import com.imooc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rj on 18/2/27.
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value="/listarea",method= RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Area> list =  areaService.queryArea();
        map.put("listArea",list);
        return map;
    }

    @RequestMapping(value="/getareabyid",method= RequestMethod.GET)
    private Map<String,Object> getAreaById(){
        Map<String,Object> map = new HashMap<String,Object>();
        Area area =  areaService.queryAreaById(1);
        map.put("area",area);
        return map;
    }

    @RequestMapping(value="/addarea",method= RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",areaService.insertArea(area));
        return map;
    }

    @RequestMapping(value="/updatearea",method= RequestMethod.POST)
    private Map<String,Object> updateArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",areaService.updateArea(area));
        return map;
    }

    @RequestMapping(value="/deletearea",method= RequestMethod.POST)
    private Map<String,Object> deleteArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",areaService.deleteArea(area));
        return map;
    }
}
