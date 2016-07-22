package com.tianziyihao.test;

import com.auth0.jwt.JWTSigner;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by longjianlin on 16/4/12.
 */
public class JWTSignerTest {
    private static JWTSigner signer = new JWTSigner("my secret");

    @Test
    public void shouldSignEmpty() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("uid","1");
        claims.put("email","e@gmail.com");
        String token = signer.sign(claims);
        assertEquals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.e30.86pkOAQxvnSDd91EThNNpOTbO-hbvxdssnFjQqT04NU", token);
    }
}
