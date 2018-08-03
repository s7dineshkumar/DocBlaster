package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    //InputStream input = null;
    private static ConfigUtil sInstance;
    public Properties myProp;

    // Prevent duplicate objects - constructor:
    private ConfigUtil() throws IOException {
        Properties prop = new Properties();
        //prop.load(getClass().getResourceAsStream("src/test/resources/config.properties")); E:/Docblaster/src/test/resources/config.properties
        FileInputStream input = new FileInputStream("./src/test/resources/config.properties");
        prop.load(input);
        myProp = prop;
    }
    //one object:
    public static String get(String Key) throws IOException {
        //one time execution and create variable:
        if (sInstance == null) {
            sInstance = new ConfigUtil();
        }
        return sInstance.myProp.getProperty(Key);
    }
}