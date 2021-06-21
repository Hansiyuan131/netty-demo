package com.tt.demo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json解析工具
 *
 * @author hansiyuan
 * @date 2021年06月19日 16:37
 */
public class JsonUtil {
    public static Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private JsonUtil() {
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        return gson.fromJson(jsonStr, clazz);
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
}
