package com.kaikele.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;

/**
 * Created by longjianlin on 7/22/16.
 */
public class CommonController extends Controller {

    @Before(GET.class)
    public void index(){
        render("/index.html");
    }
}

