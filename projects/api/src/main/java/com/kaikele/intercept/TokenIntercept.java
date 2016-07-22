package com.kaikele.intercept;

import com.kaikele.common.Message;
import com.kaikele.util.Token;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.apache.commons.httpclient.HttpStatus;

/**
 * token 认证
 * Created by longjianlin on 16/4/13.
 */
public class TokenIntercept implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        String token = invocation.getController().getRequest().getHeader("Authorization");
        boolean isAuth = false;
        if (null != token){
            String[] arr = token.split("Bearer ",token.length());
            if (null != arr && arr.length==2){
                try {
                    Token.verify(arr[1]);
                    isAuth = true;
                } catch (Exception e) {
                    //verify fail
                }
            }
        }
        if (isAuth){
            invocation.invoke();
        }else{
            Message message = new Message(HttpStatus.SC_UNAUTHORIZED,"Invalid signature",null);
            invocation.getController().renderJson(message);
        }
    }
}
