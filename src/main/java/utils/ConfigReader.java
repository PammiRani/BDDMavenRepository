package utils;


import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties initializeProperties() {

         prop = new Properties();

        try {
//            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\config\\config.properties");
            FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\config\\config.properties");
            prop.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

             return prop;
    }
}
