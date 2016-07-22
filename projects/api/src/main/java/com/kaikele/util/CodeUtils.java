package com.kaikele.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 * 生成课程码
 * <p>
 * 生成12位不重复的字符 (字母 + 数字)
 * <p>
 * Created by longjianlin on 16/7/13.
 */
public class CodeUtils {
    public static String createCode() {
        String id = UUID.randomUUID().toString();

        id = DEKHash(id) + "";

        int diff = 12 - id.length();
        String randStr = RandomStringUtils.randomAlphabetic(12);
        for (int i = 0; i < diff; i++) {
            int randIndex = (int) (Math.random() * randStr.length());
            int index = (int) (Math.random() * id.length());
            id = id.substring(0, index) + randStr.charAt(randIndex) + id.substring(index, id.length());
        }
        return id;
    }

    private static int DEKHash(String str) {
        int hash = str.length();

        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);
        }

        return (hash & 0x7FFFFFFF);
    }


//    public static void main(String[] args) {
//        System.out.println(createCode());
//    }
}
