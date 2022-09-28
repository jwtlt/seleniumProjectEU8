package com.cydeo;

import com.utility.ConfigReader;
import com.utility.Driver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class P23_ReadingPropertyFile{

    @Test
    public void testReadingProperties() {

        Properties properties = new Properties();

        try {
        FileInputStream in = new FileInputStream("config.property");
        properties.load(in);
        in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String hello = properties.getProperty("hello");
        System.out.println(hello);

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

    }

    @Test
    public void testWebOrderLogin(){

        String url = ConfigReader.read("weborder_url");
        String username = ConfigReader.read("weborder_username");
        String password = ConfigReader.read("weborder_password");

        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        Driver.getDriver().navigate().to(url);

    }

}
