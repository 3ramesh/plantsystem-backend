package net.plantsystem.application.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author rames on 2023-03-16
 */
public class StringUtil {

    public static String splitByCharacterTypeCamelCase(String name) {
        return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase
                (name.replaceAll("\\d+", "")), " ");
    }
}
