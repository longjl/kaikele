package com.kaikele.controller;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.kaikele.common.Message;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 上传
 * Created by longjianlin on 16/7/15.
 */
public class UploadController extends Controller {
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(UploadController.class);


    /**
     * 课程封面上传
     */
    public void cover() {
        UploadFile uploadFile = getFile();
        File file = uploadFile.getFile();
        String sufName = uploadFile.getFileName().substring(uploadFile.getFileName().lastIndexOf("."), uploadFile.getFileName().length());
        String imgPath = uploadFile.getUploadPath() + File.separator + System.currentTimeMillis() + sufName;

        File dest = new File(imgPath);
        file.renameTo(dest);//重命名

        Map<String, Object> data = new HashMap<>();
        data.put("cover", dest.getName());
        Message message = new Message(HttpStatus.SC_OK, "success", data);
        renderJson(message);
    }
}
