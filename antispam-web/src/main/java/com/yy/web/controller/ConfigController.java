package com.yy.web.controller;

import com.yy.business.dao.custom.CustomAppModuleMapper;
import com.yy.business.dao.gen.model.AppModule;
import com.yy.cs.base.json.Json;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/25.
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    CustomAppModuleMapper customAppModuleMapper;

    @RequestMapping(value = "/getModuleArg", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getModuleArg(
            HttpServletRequest request,
            @RequestParam  Integer moduleId) throws Exception {
        AppModule module = customAppModuleMapper.selectByPrimaryKey(moduleId);
        return module.getModuleArg();
    }
}
