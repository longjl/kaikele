package com.kaikele.controller;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.kaikele.common.AppConstants;
import com.kaikele.common.MatrixToImageWriter;
import com.kaikele.common.Message;
import com.kaikele.model.Course;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Page;
import com.kaikele.util.CodeUtils;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by longjianlin on 16/7/11.
 */
public class CourseController extends Controller {
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(CourseController.class);

    @Before(GET.class)
    public void page() {
        int pageNumber = getParaToInt("pageNumber");
        Page<Course> page = Course.dao.paginate(pageNumber, AppConstants.PAGE_SIZE, "select id,title", "from course");
        Map<String, Object> data = new HashMap<>();
        data.put("data", page);
        Message message = new Message(HttpStatus.SC_OK, "success", data);
        renderJson(message);
    }

    //创建课程第一步
    public void step1() {
        render("/step1.html");
    }

    //创建课程第二步
    public void step2() {
        int template_id = getParaToInt("template_id");
        setAttr("template_id", template_id);
        render("/step2.html");
    }

    //创建课程第三步
    @Before(POST.class)
    public void setp3() {
        String title = getPara("title");
        String cover = getPara("cover");
        String url = getPara("url");
        String desc = getPara("desc");
        String lesson_number = getPara("lesson_number");
        String price = getPara("price");
        String open_date = getPara("open_date");
        int template_id = getParaToInt("template_id");
        //未注册用户需要生成课程码
        String course_code = CodeUtils.createCode();
        //生成课程二维码
        String qr_code = MatrixToImageWriter.generateQRcode("https://baidu.com");

        Course course = new Course().set("title", title)
                .set("course_code", course_code)
                .set("desc", desc)
                .set("cover", cover)
                .set("lesson_number", lesson_number)
                .set("price", price)
                .set("sort", 0)
                .set("status", "true")
                .set("url", url)
                .set("template_id", template_id)
                .set("qr_code", qr_code)
                .set("open_date", open_date)
                .set("create_at", new Date());
        course.save();

        Map<String, Object> data = new HashMap<>();
        data.put("course", course);
        Message message = new Message(HttpStatus.SC_OK, "success", data);
        renderJson(message);
    }

    public void detail() {
        int id = getParaToInt();
        Course course = Course.dao.findById(id);
        setAttr("course",course);
        render("/step3.html");
    }


    //模板页
    public void template(){
        String course_id = getPara("course_id");

    }


    /**
     * 根据课程码查询课程信息
     */
    @Before(GET.class)
    public void getCourseByCode() {
        String code = getPara("code");
        Course course = Course.dao.getCourseByCode(code);
        Map<String, Object> data = new HashMap<>();
        Message message = null;
        if (course != null) {
            data.put("course", course);
            message = new Message(HttpStatus.SC_OK, "success", data);
        } else {
            message = new Message(HttpStatus.SC_NO_CONTENT, "no content", data);
        }
        renderJson(message);
    }




    /**
     * 添加课程
     */
    @Before(POST.class)
    public void add() {
        //标题
        String title = getPara("title");
        //描述
        String desc = getPara("desc");
        //封面
        String cover = getPara("cover");
        //课节数
        //String lesson_number = getPara("lesson_number");
        //课程价格
        //int price = getParaToInt("price");
        //排序
        //int sort = getParaToInt("sort");
        //状态 (true上架,false下架)
        //String status = getPara("status");
        //地址(音频,视频,课件,程序)
        String url = getPara("url");

        //课程模板
        int templateId = getParaToInt("templateId");

        //生成课程二维码
        String qr_code = MatrixToImageWriter.generateQRcode("https://baidu.com");

        Course course = new Course().set("title", title)
                .set("desc", desc)
                .set("cover", cover)
                .set("lesson_number", 0)
                .set("price", 0)
                .set("sort", 0)
                .set("status", "true")
                .set("url", url)
                .set("qr_code", qr_code)
                .set("create_at", new Date());

        //未注册用户需要生成课程码
        String code = CodeUtils.createCode();

        //执行事务(需要保证所有的操作都成功,否则将不做任何事)
        boolean success = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
//                boolean isSaveCourse = course.save();  //保存课程信息
//                boolean isSaveCourseCode =  new CourseCode().set("code", code).set("course_id", course.get("id")).save();        //保存课程码
//                boolean isSaveCourseTemplate = new CourseTemplate().set("template_id", templateId).set("course_id", course.get("id")).save();//保存课程与模板关联数据
//
//                return isSaveCourse && isSaveCourseCode && isSaveCourseTemplate;
                return true;
            }
        });

        Map<String, Object> data = new HashMap<>();
        data.put("course", course);
        Message message = new Message(HttpStatus.SC_OK, "success", data);
        renderJson(message);
    }

    /**
     * 编辑课程
     */
    @Before(POST.class)
    public void edit() {
        //编号
        int id = getParaToInt("id");
        //标题
        String title = getPara("title");
        //描述
        String desc = getPara("desc");
        //封面
        String cover = getPara("cover");
        //地址(音频,视频,课件,程序)
        String url = getPara("url");

        Course course = Course.dao.findById(id);
        if (null != course) {
            course.set("title", title);
            course.set("desc", desc);
            course.set("cover", cover);
            course.set("url", url);
            course.update();
        }

        Message message = new Message(HttpStatus.SC_OK, "success", null);
        renderJson(message);
    }

    /**
     * 删除课程
     */
    @Before(GET.class)
    public void delete() {
        int id = getParaToInt("id");
        Course course = Course.dao.findById(id);
        if (null != course) {
            course.delete();
        }
        Message message = new Message(HttpStatus.SC_OK, "success", null);
        renderJson(message);
    }
}
