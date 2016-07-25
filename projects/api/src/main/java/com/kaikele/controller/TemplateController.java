package com.kaikele.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.kaikele.model.Course;

/**
 * 模板
 * Created by longjianlin on 7/25/16.
 */
public class TemplateController extends Controller{

    //视频模板
    @Before(GET.class)
    public void video(){
        int id = getParaToInt();
        Course course = Course.dao.findById(id);
        setAttr("course",course);
        render("/template/video.html");
    }
}
