package com.seem.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件工具类！
 */
public class PropertiesUtils {

    private static final Properties pro = new Properties();
    static{
        try {
            InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据键读取配置
     * @param key
     * @return
     */
    public static String getProperties(String key){
        return pro.getProperty(key);
    }

    public static double getDoubleProperties(String key){
        return Double.parseDouble(pro.getProperty(key));
    }
}
