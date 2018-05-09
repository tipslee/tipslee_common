package com.jd.innovation.common.utils;

/**
 * 短码生成工具类
 * @author liqiang
 * 2016/8/4
 */
public class ShortCodeUtil {
    /**
     * 52位字符表：去除l,o,O,Q
     */
    public static final String[] ORIGIN_CHARACTER_SE = {
            "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "m", "n", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "P", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    /**
     * 短码字符表，不可更改
     */
    public static final String[] CHARACTER_SE = {
            "S", "k", "h", "r", "Z", "t", "E", "f",
            "J", "F", "L", "K", "a", "X", "N", "j",
            "d", "Y", "s", "M", "G", "n", "C", "A",
            "m", "V", "b", "W", "c", "w", "P", "u"
    };

    /**
     * 短码位数不够补充字符
     */
    private static final String CodeComplement = "Q";

    /**
     * 短码长度：6位
     */
    private static final int CodeLength = 6;
    /**
     * 每一位短码二进制长度：2^n=CHARACTER_SE.length
     */
    private static final int CodeDigit = 5;
    /**
     * 二进制位数不够补偿字符
     */
    private static final int BinaryComplement = 0;

    public static String getShortCode(Long uniqueId) {
        String binary = Long.toBinaryString(uniqueId);
        binary = binaryComplement(binary);
        String code = enCode(binary);
        code = codeComplement(code);
        return code;
    }

    private static String codeComplement(String code) {
        int remainNumbers = CodeLength - code.length();
        for (int k = 0; k < remainNumbers; k++) {
            code = code + CodeComplement;
        }
        return code;
    }

    private static String enCode(String binary) {
        String code = "";
        int numbers = binary.length() / CodeDigit;
        for (int j = 0; j < numbers; j++) {
            String str = binary.substring(j * CodeDigit, (j + 1) * CodeDigit);
            int index = Integer.parseInt(str, 2);
            code = code + CHARACTER_SE[index];
        }
        return code;
    }

    private static String binaryComplement(String binary) {
        int remainder = binary.length() % CodeDigit;
        if (remainder == 0) {
            return binary;
        }
        for (int i = remainder; i < CodeDigit; i++) {
            binary = BinaryComplement + binary;
        }
        return binary;
    }
}
