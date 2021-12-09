package com.zzq.learn.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;

import java.util.Objects;

public class SaltUtil {

    private static final char[] charArr = initCharArr();
    private static char[] initCharArr() {
        // ASCII码(0~z)
        byte start = 48, end = 122;
        char[] chars = new char[end - start + 1];
        for (char i = 0; i < chars.length; i++) {
            chars[i] = (char) (start + i);
        }
        return chars;
    }

    public static String createSalt() {
        char[] chars = new char[6];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = charArr[RandomUtil.randomInt(0, charArr.length)];
        }
        return new String(chars);
    }

    public static String md5(String password, String salt) {
        return MD5.create().setSalt(salt.getBytes()).digestHex(password);
    }

    public static boolean md5Eq(String md5, String password, String salt) {
        return Objects.equals(md5, md5(password, salt));
    }

}