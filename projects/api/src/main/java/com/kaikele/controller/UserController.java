package com.kaikele.controller;

import com.kaikele.common.Message;
import com.kaikele.intercept.TokenIntercept;
import com.kaikele.util.Token;
import com.kaikele.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * User Controller
 * Created by longjianlin on 16/4/12.
 */
public class UserController extends Controller {
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(UserController.class);

    //user login
    @Before(POST.class)
    public void login() {
        String username = getPara("username");
        String pwd = getPara("pwd");
        Message message = null;
        Map<String, Object> data = new HashMap<>();
        User user = User.dao.findUserByUsernameAndPwd(username, pwd);
        if (null != user) {
            logger.info(username + " login success.");
            String token = Token.getToken(user);
            data.put("token", token);
            message = new Message(HttpStatus.SC_OK, "ok", data);
        } else {
            logger.info(username + " login fail.");
            message = new Message(HttpStatus.SC_NOT_FOUND, "not found", data);
        }
        renderJson(message);
    }

    //user register
    @Before(POST.class)
    public void register() {
        String nickname = getPara("nickname");
        String email = getPara("email");
        String pwd = getPara("pwd");
        Message message = null;

        //email exists
        boolean isExist = User.dao.findUserByEmail(email);
        if (isExist) {
            logger.info(email + " created.");
            message = new Message(HttpStatus.SC_CREATED, "email created.", null);
        } else {
            boolean isReg = User.dao.addUser(nickname, email, pwd);
            if (isReg) {
                logger.info(nickname + " register success.");
                message = new Message(HttpStatus.SC_OK, "ok", null);
            } else {
                logger.info(nickname + " register fail.");
                message = new Message(-1, "register fail", null);
            }
        }
        renderJson(message);
    }


    //get user info
    @Before({GET.class, TokenIntercept.class})
    public void getUserInfo() throws Exception {
        Map<String, Object> map = Token.parseToken(getRequest());
        User user = User.dao.findById(map.get("id"));
        if (null != user) {
            user.remove("pwd");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        Message message = new Message(HttpStatus.SC_OK, "ok", data);
        renderJson(message);
    }

    /**
     * 根据id获取用户信息
     */
    @Before(GET.class)
    public void getUserById(){
        Message message = null;
        try{
            Integer userId = getParaToInt();
            User user = User.dao.findById(userId);
            if (null != user) {
                user.remove("pwd");
                Map<String, Object> data = new HashMap<>();
                data.put("user", user);
                message = new Message(HttpStatus.SC_OK, "success", data);
            }else{
                message = new Message(HttpStatus.SC_NOT_FOUND, "no found", null);
            }
        }catch (Exception e){
            message = new Message(-1, "fail", null);
        }
        renderJson(message);
    }

}
