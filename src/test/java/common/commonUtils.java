package common;
import java.io.*;
import java.util.Properties;


public class commonUtils {
    public static String readProperties(String propkey) {
        String basedir = System.getProperty("user.dir");
        Properties prop = new Properties();
        String retval = "";
        InputStream input = null;
        try {
            input = new FileInputStream("./src/test/resources/environment.properties");
            prop.load(input);
            retval = prop.getProperty(propkey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retval;
    }
}

