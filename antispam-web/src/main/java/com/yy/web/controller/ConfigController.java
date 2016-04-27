package com.yy.web.controller;

import com.yy.business.dao.custom.CustomModuleMapper;
import com.yy.business.dao.gen.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/4/25.
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    CustomModuleMapper customAppModuleMapper;

    @RequestMapping(value = "/getModuleArg", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getModuleArg(
            HttpServletRequest request,
            @RequestParam  Integer moduleId) throws Exception {
        Module module = customAppModuleMapper.selectByPrimaryKey(moduleId);
        return module.getModuleArg();
    }
}
