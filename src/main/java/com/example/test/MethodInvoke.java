package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.lang.reflect.Method;

public class MethodInvoke {

    @Test
    public void test2() throws Exception{
        JSONArray jsonArray = test(JSONArray.class);
        System.out.println(jsonArray);
    }
    /**
     *
     * @param T 你要选择的解析结果的类
     * @return
     * @throws Exception
     */
    private <T extends JSON> T  test(Class<T> T) throws Exception{
        String params = "[{'name':'11'},{'name':'13'}]";
        String name = T.getName();
        Class<?> threadClazz = Class.forName(name);
        Method method = threadClazz.getMethod("parseArray", String.class);
        Object resultObj = method.invoke(null,params);
        return (T)resultObj;
    }

}
