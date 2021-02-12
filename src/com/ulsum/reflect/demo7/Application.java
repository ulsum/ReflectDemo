package com.ulsum.reflect.demo7;

import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.Properties;

public class Application {

    public static void say(){
        Properties properties = new Properties();
        String configPath = Application.class.getResource("/config.properties").getPath();
        try {
            configPath = new URLDecoder().decode(configPath,"UTF-8");
            properties.load(new FileInputStream(configPath));
            String language = properties.getProperty("language");
            I18N i18N = (I18N)Class.forName(language).newInstance();
            System.out.println(i18N.say());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        say();
    }

}
