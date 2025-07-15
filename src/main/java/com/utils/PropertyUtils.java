package com.utils;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}

    private static final Properties property = new Properties();
    private static final Map<String, String> CONFIG_MAP = new HashMap<>();

    static {
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(file);

            for (Map.Entry<Object, Object> entry : property.entrySet()){
                CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


    public static String getValue(ConfigProperties key) {

        if(Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))){
            throw new PropertyFileUsageException("Property " + key + " not found in 'config.properties' file");
        }
        return CONFIG_MAP.get(key.name().toLowerCase());
    }
}
