package com.base.util;

import org.springframework.util.ObjectUtils;

/**
 * @author yhc
 * @create 2023-08-24 17:06
 */
public class StringUtil {

    /**
     * 下划线转驼峰 例如：user_name  ---->  userName
     *
     * @param str 需要被转换的字符串
     * @param firstToUpper 首字母是否大写
     * @return 转换后的字符串
     * @author yhc
     * @date 2020/4/27 9:56
     */
    public static String underlineToHump(String str, boolean firstToUpper) {
        if (ObjectUtils.isEmpty(str)) {
            return null;
        }
        // 截取下划线分成数组
        char[] charArray = str.toCharArray();
        if (firstToUpper) {
            charArray[0] = (charArray[0]+ "").toUpperCase().charAt(0);
        }
        // 判断上次循环的字符是否是"_"
        boolean underlineBefore = false;
        StringBuilder buffer = new StringBuilder();
        for (char c : charArray) {
            // 判断当前字符是否是"_",如果跳出本次循环
            if (c == '_') {
                underlineBefore = true;
            } else if (underlineBefore) {
                // 如果为true，代表上次的字符是"_",当前字符需要转成大写
                buffer.append(new String(new char[] { c }).toUpperCase());
                underlineBefore = false;
            } else { // 不是"_"后的字符就直接追加
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * 驼峰转下划线 例如：userName  ---->  user_name
     *
     * @param str 需要被转换的字符串
     * @return 转换后的字符串
     * @author yhc
     * @date 2020/4/27 9:57
     */
    public static String humpToUnderline(String str) {
        if (ObjectUtils.isEmpty(str)) {
            return null;
        }
        // 首个字符转小写
        str = str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
        // 截取下划线分成数组，
        char[] charArray = str.toCharArray();
        StringBuilder buffer = new StringBuilder();
        // 处理字符串
        for (char c : charArray) {
            if (c >= 65 && c <= 90) {
                buffer.append("_").append(new String(new char[] { c }).toLowerCase());
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}
