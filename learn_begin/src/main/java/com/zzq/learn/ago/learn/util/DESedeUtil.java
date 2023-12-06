package com.zzq.learn.ago.learn.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class DESedeUtil {

    private final static String salt = "nginxwise";

    private static SymmetricCrypto des() {
        byte[] temp = StrUtil.bytes(DigestUtil.md5Hex(salt));
        byte[] key = new byte[24];
        System.arraycopy(temp, 0, key, 0, key.length);
        return new SymmetricCrypto(SymmetricAlgorithm.DESede, key);
    }

    public static String encode(String str) {
        return des().encryptBase64(str);
    }

    public static String decode(String str) {
        return des().decryptStr(str);
    }

}
