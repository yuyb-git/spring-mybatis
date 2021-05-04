package com.meteor.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName CommonUtil
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class CommonUtil {

    private static final Pattern PATTERN = Pattern.compile("[A-Z]");

    public static String camelCaseToUnderscore(String val) {
        Matcher matcher = PATTERN.matcher(val);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
