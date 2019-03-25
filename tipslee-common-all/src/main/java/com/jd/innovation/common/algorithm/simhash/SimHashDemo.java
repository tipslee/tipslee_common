package com.jd.innovation.common.algorithm.simhash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liqiang
 * @description
 * @time 2018年03月21日
 * @modifytime
 */
public class SimHashDemo {

    public static void main(String[] args) {
        List<String> sku1User = new ArrayList<String>(Arrays.asList("Buenos", "Crdoba", "La", "Aires", "Plata"));
        List<String> sku2User = new ArrayList<String>(Arrays.asList("Jack", "Tob", "Sara", "Lc", "Parad"));
        List<String> sku3User = new ArrayList<String>(Arrays.asList("Mill", "Jack", "Sim", "Joe", "Joy"));
        List<String> sku4User = new ArrayList<String>(Arrays.asList("小李", "fsd", "432141", "Jckew"));
        List<String> sku5User = new ArrayList<String>(Arrays.asList("lizyin90", "小李", "老版", "李返回", "力气"));
        List<String> sku6User = new ArrayList<String>(Arrays.asList("小李", "432141", "Jckew"));

        String simHash1 = SimHashUtil.simHash(sku1User, SimHashUtil.NEWS_TF);
        String simHash2 = SimHashUtil.simHash(sku2User, SimHashUtil.NEWS_TF);
        String simHash3 = SimHashUtil.simHash(sku3User, SimHashUtil.NEWS_TF);
        String simHash4 = SimHashUtil.simHash(sku4User, SimHashUtil.NEWS_TF);
        String simHash5 = SimHashUtil.simHash(sku5User, SimHashUtil.NEWS_TF);
        String simHash6 = SimHashUtil.simHash(sku6User, SimHashUtil.NEWS_TF);

        List<String> skuUser = new ArrayList<String>(Arrays.asList("32132da", "jd_79c31232c05ad", "小李", "fsd", "李返回2"));
        String simHash = SimHashUtil.simHash(skuUser, SimHashUtil.NEWS_TF);


        List<String> k1 = new ArrayList<String>();
        for (String temp : sku1) {
            if (temp.startsWith("jd_")) {
                temp = temp.replace("jd_", "");
            }
            if (temp.endsWith("_p")) {
                temp = temp.replace("_p", "");
            }
//            if (temp.endsWith("_m")) {
//                temp = temp.replace("_m", "");
//            }
            k1.add(temp);
        }

        List<String> k2 = new ArrayList<String>();
        for (String temp : sku2) {
            if (temp.startsWith("jd_")) {
                temp = temp.replace("jd_", "");
            }
            if (temp.endsWith("_p")) {
                temp = temp.replace("_p", "");
            }
//            if (temp.endsWith("_m")) {
//                temp = temp.replace("_m", "");
//            }
            k2.add(temp);
        }

        System.out.println(SimHashUtil.simHash(sku2, SimHashUtil.NEWS_TF));
        System.out.println("1011001111011111001001011110000100010000011000100001101100110101");
//        System.out.println(SimHashUtil.hash("jd_7cda07da8c610"));

//        String simHash7 = SimHashUtil.simHash(k1, SimHashUtil.NEWS_TF);
//        String simHash8 = SimHashUtil.simHash(k2, SimHashUtil.NEWS_TF);
//        System.out.println(SimHashUtil.hammingDistance(simHash7, simHash8));
//
//        System.out.println(SimHashUtil.hammingDistance(simHash7, simHash1));
//        System.out.println(SimHashUtil.hammingDistance(simHash7, simHash2));
//        System.out.println(SimHashUtil.hammingDistance(simHash7, simHash3));
//        System.out.println(SimHashUtil.hammingDistance(simHash7, simHash4));
//        System.out.println(SimHashUtil.hammingDistance(simHash7, simHash5));
//        System.out.println(SimHashUtil.hammingDistance(simHash7, simHash6));
//
//        System.out.println("-----------------------------");
//
//        System.out.println(SimHashUtil.hammingDistance(simHash8, simHash1));
//        System.out.println(SimHashUtil.hammingDistance(simHash8, simHash2));
//        System.out.println(SimHashUtil.hammingDistance(simHash8, simHash3));
//        System.out.println(SimHashUtil.hammingDistance(simHash8, simHash4));
//        System.out.println(SimHashUtil.hammingDistance(simHash8, simHash5));
//        System.out.println(SimHashUtil.hammingDistance(simHash8, simHash6));
    }

    public static List<String> sku2 = new ArrayList<String>(Arrays.asList(""
    ));


    public static List<String> sku1 = new ArrayList<String>(Arrays.asList(""
    ));
}


