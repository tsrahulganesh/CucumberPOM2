package Utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Configreader {

        static Properties getLoadedPropertiesObject() throws IOException {
            // 1. read the file

            FileInputStream fis = new FileInputStream("Config/Config.properties");

            // 2. create object of properties class

            Properties prop = new Properties();

            // 3. load this object with file
            prop.load(fis);

            return prop;
        }


        public static String getUrl() throws IOException {
            return getLoadedPropertiesObject().getProperty("url");
        }

       /* public static String getUsername() throws IOException {
            return getLoadedPropertiesObject().getProperty("username");
        }

        public static String getPassword() throws IOException {
            return getLoadedPropertiesObject().getProperty("password");
        }*/
    }


