package com.kaikele.util;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.kaikele.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Token
 * Created by longjianlin on 16/4/13.
 */
public class Token {
    private static final String SECRET = "tianziyihao";
    private static JWTVerifier verifier = new JWTVerifier(SECRET);
    private static JWTSigner signer = new JWTSigner(SECRET);

    /**
     * get token
     *
     * @param user
     * @return
     */
    public static String getToken(User user) {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", user.get("id"));
        claims.put("email", user.get("email"));
        return signer.sign(claims);
    }

    /**
     * token 认证
     *
     * @param token
     * @throws Exception
     */
    public static void verify(String token) throws Exception {
        verifier.verify(token);
    }

    /**
     * 解析token
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, Object> parseToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader("Authorization");
        String[] arr = token.split("Bearer ",token.length());
        return verifier.verify(arr[1]);
    }
}
