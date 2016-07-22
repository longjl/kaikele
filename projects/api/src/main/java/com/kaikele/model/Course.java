package com.kaikele.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by longjianlin on 16/7/11.
 */
public class Course extends Model<Course> {
    public static final Course dao = new Course();


    /**
     * 根据课程码查询课程
     *
     * @param code
     * @return
     */
    public Course getCourseByCode(final String code) {
        return Course.dao.findFirst("select c.* from course c left join course_code cc on c.id = cc.course_id where cc.`code` = ?", code);
    }

    /**
     * 根据id获取课程
     *
     * @param id
     * @return
     */
    public Course getCourseById(final int id) {
        return Course.dao.findFirst("select c.*,cc.code from course c left join course_code cc on c.id = cc.course_id where c.id = ?",id);
    }
}
