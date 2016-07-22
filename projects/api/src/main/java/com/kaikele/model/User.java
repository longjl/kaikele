package com.kaikele.model;


import com.kaikele.util.MD5;
import com.jfinal.plugin.activerecord.Model;

import java.util.Date;

public class User extends Model<User> {

    public static final User dao = new User();


    /**
     * find user by username and pwd
     *
     * @param username
     * @param pwd
     */
    public User findUserByUsernameAndPwd(String username, String pwd) {
        return dao.findFirst("select * from users u where u.email=? and u.pwd=?", username, MD5.GetMD5Code(pwd));
    }

    /**
     * find user by email
     *
     * @param email
     * @return
     */
    public boolean findUserByEmail(String email) {
        return dao.findFirst("select u.id from users u where u.email=?", email) != null;
    }

    /**
     * create a new user
     *
     * @param nickname
     * @param email
     * @param pwd
     */
    public boolean addUser(String nickname, String email, String pwd) {
        return new User().set("nickname", nickname)
                .set("email", email)
                .set("pwd", MD5.GetMD5Code(pwd))
                .set("avatar","https://secure.gravatar.com/avatar/1921f29c6fc487db7864e1dda0ae357e?d=https%3A//daks2k3a4ib2z.cloudfront.net/img/profile-user.png")
                .set("create_at", new Date()).save();
    }

}
