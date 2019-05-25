package xyz.thishome.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    /**
     * 传入配置文件，key，获取配置文件中key对应的值
     *
     * @param pro
     * @param key
     * @return
     * @throws IOException
     */
    public static String getValue(String pro, String key) throws IOException {
        InputStream inputStream = null;
        try {
            Properties properties = new Properties();
            inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(pro);
            properties.load(inputStream);
            return properties.getProperty(key);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

}
