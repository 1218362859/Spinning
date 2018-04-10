package com.femtoapp.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigUtil {
    private static Properties pro;

    static{
        pro=new Properties();
        //Ĭ�ϴ�������ڰ�Ŀ¼��ʼ������Դ�ļ�
        //���Ҫclasspath�ĸ�Ŀ¼��ʼ�ң��������/
        /*InputStream input=PropertiesUtil.class.
                getResourceAsStream("/config.properties");*/
        //Ĭ�ϴ�classspath�ĸ�Ŀ¼��ʼ������Դ�ļ�
        InputStream input=ConfigUtil.class
                .getClassLoader()
                .getResourceAsStream("config.properties");


        try {
            pro.load(new InputStreamReader(input,
                    "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String get(String key){
        return pro.getProperty(key);
    }

    public static int getInt(String key){
        return Integer.parseInt(pro.getProperty(key));
    }

}