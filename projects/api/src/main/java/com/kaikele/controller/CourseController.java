package com.kaikele.controller;

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
                .set("open_date", open_date)
                .set("create_at", new Date());
        course.save();

        //生成课程二维码
        String qr_code = MatrixToImageWriter.generateQRcode("http://10.0.0.8:8082/template/video/" + course.get("id"));
        course.set("qr_code", qr_code).update();

        Map<String, Object> data = new HashMap<>();
        data.put("course", course);
        Message message = new Message(HttpStatus.SC_OK, "success", data);
        renderJson(message);
    }

    @Before(GET.class)
    public void detail() {
        int id = getParaToInt();
        Course course = Course.dao.findById(id);
        setAttr("course", course);
        render("/step3.html");
    }

    //编辑课程信息完成
    @Before(GET.class)
    public void complete() {
        int id = getParaToInt();
        Course course = Course.dao.findById(id);
        setAttr("course", course);
        render("/complete.html");
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
     * 课程管理
     */
    @Before(GET.class)
    public void manager() {
        setAttr("error", "");
        setAttr("course_code","");
        render("/manager.html");
    }

    @Before(GET.class)
    public void editCourse() {
        String course_code = getPara("course_code");
        Course course = Course.dao.findFirst("select * from course where course_code=?", course_code);
        if (course != null) {
            setAttr("course", course);
            render("/edit_course.html");
        } else {
            setAttr("course_code",course_code);
            setAttr("error", "no course.");
            render("/manager.html");
        }
    }

    @Before(POST.class)
    public void edit() {
        String title = getPara("title");
        String cover = getPara("cover");
        String url = getPara("url");
        String desc = getPara("desc");
        String lesson_number = getPara("lesson_number");
        String price = getPara("price");
        String open_date = getPara("open_date");
        String course_code = getPara("course_code");
        Course course = Course.dao.findFirst("select * from course where course_code=?", course_code);
        if (course != null) {
            course.set("title", title)
                    .set("desc", desc)
                    .set("cover", cover)
                    .set("lesson_number", lesson_number)
                    .set("price", price)
                    .set("url", url)
                    .set("open_date", open_date);

            course.update();
        }
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
}
