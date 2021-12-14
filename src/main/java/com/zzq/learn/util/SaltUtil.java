package com.zzq.learn.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import com.zzq.learn.model.entity.User;

import java.util.Objects;

public class SaltUtil {

    // ASCII码(0~z)
    private static final byte start = 48, end = 122;
    private static final byte saltLen = 6;

    public static String createSalt() {
        char[] chars = new char[saltLen];
        for (int i = 0; i < saltLen; i++) {
            chars[i] = (char) RandomUtil.randomInt(start, end);
        }
        return new String(chars);
    }

    public static String md5(String password, String salt) {
        return MD5.create().setSalt(salt.getBytes()).digestHex(password);
    }

    public static boolean md5Eq(String md5, String password, String salt) {
        return Objects.equals(md5, md5(password, salt));
    }

    public static void setPassword(User user) {
        String salt = createSalt();
        user.setSalt(salt);
        user.setPassword(md5(user.getPassword(), salt));
    }

}