package com.as.java.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author as
 * @date 2022/1/24
 * @desc
 */
public class PinyinTest {
    public static String toFirstChar (String chinese){
        StringBuilder pinyinStr = new StringBuilder();
        char[] newChar = chinese.toCharArray();  //转为单个字符
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    String[] strings = PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat);
                    if (null != strings && strings.length>0) {
                        pinyinStr.append(strings[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinStr.append(newChar[i]);
            }
        }
        return pinyinStr.toString().toUpperCase();
    }
    public static void main(String[] args) {
        System.out.println(toFirstChar("AC群脑膜炎球菌（结合）B型流感嗜血杆菌(结合)联合疫苗"));
    }
}
