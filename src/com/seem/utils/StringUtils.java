package com.seem.utils;

public class StringUtils {

    /**
     * 判断字符串是否为为空
     * @param content
     * @return
     */
    public boolean isEmpty(String content){
        return content == null || content.length() == 0 ? true : false;
    }

    /**
     * 异或加密
     * 对密码进行加密并返回加密后的内容！
     * @content 原始密码
     * @return  加密后的内容
     */
    public String encryptionWithPasswordByXor(String content){
        return "";
    }

    public String encryptionWithPasswordByMd5(String content){
        return "";
    }
}
