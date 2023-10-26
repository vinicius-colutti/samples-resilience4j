package com.colutti.newsapi.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationPropertiesReader {

    private Properties properties;
    private String PROPERTIES_FILE_NAME="D:\\Workspaces\\Java11\\sample-resilience4j\\samples-without-annotations\\sample-circuitbreaker\\news-api\\src\\main\\resources\\application.properties";

    public ApplicationPropertiesReader(){
        this.properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(PROPERTIES_FILE_NAME);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getPropertyByName(String propertyName){
        return this.properties.getProperty(propertyName);
    }

}

