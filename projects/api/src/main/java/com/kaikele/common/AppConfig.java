package com.kaikele.common;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.kaikele.controller.CommonController;
import com.kaikele.controller.CourseController;
import com.kaikele.controller.UploadController;
import com.kaikele.controller.UserController;
import com.kaikele.model.*;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

public class AppConfig extends JFinalConfig {

    /**
     * 配置常量
     */
    public void configConstant(Constants me) {
        PropKit.use("config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
//        me.setBaseUploadPath("/data/upload"); //配置上传地址

    }

    /**
     * 配置路由
     */
    public void configRoute(Routes me) {
        me.add("/", CommonController.class);
        me.add("/user", UserController.class);
        me.add("/course",CourseController.class);
        me.add("/upload",UploadController.class);
    }

    /**
     * 配置插件
     */
    public void configPlugin(Plugins me) {
        String jdbcUrl = "";
        String user = "";
        String password = "";

        if (PropKit.getBoolean("baeEvn", false)) {// bae production
            jdbcUrl = PropKit.get("bae_jdbcUrl");
            user = PropKit.get("bae_user");
            password = PropKit.get("bae_password");
        } else {// location development
            jdbcUrl = PropKit.get("loc_jdbcUrl");
            user = PropKit.get("loc_user");
            password = PropKit.get("loc_password");
        }

        // DruidPlugin
        DruidPlugin dp = new DruidPlugin(jdbcUrl, user, password);
        dp.addFilter(new StatFilter());
        WallFilter wall = new WallFilter();
        wall.setDbType("mysql");
        dp.addFilter(wall);
        me.add(dp);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setShowSql(true);
        me.add(arp);
        this.configModelMapping(arp);
        me.add(arp);
    }

    /**
     * 配置全局拦截器
     */
    public void configInterceptor(Interceptors me) {
//		me.add(new SessionInViewInterceptor());
//		me.add(new GlobalLoginInterceptor());
    }

    /**
     * 配置处理器
     */
    public void configHandler(Handlers me) {
        //监控url
        //DruidStatViewHandler dvh =  new DruidStatViewHandler("/druid");
        //me.add(dvh);
    }

    /**
     * 初始化常量
     */
    public void afterJFinalStart() {
    }

    /**
     * 添加model与表的映射
     *
     * @param arp
     */
    private void configModelMapping(ActiveRecordPlugin arp) {
        arp.addMapping("course",Course.class);
        arp.addMapping("user", User.class);
        arp.addMapping("user_course",UserCourse.class);
        arp.addMapping("template",Template.class);
    }

}
