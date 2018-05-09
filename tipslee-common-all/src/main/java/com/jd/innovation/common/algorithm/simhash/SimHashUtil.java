package com.jd.innovation.common.algorithm.simhash;



import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;
import java.util.*;

public class SimHashUtil {

    public static int WEIBO_TF = 1;
    public static int NEWS_TF = 1;
    public static int HAIMING_DISTANCE = 7;
    private static int hashbits = 64;

    public static String simHash(String tokens, int tf) {
        if (StringUtils.isBlank(tokens)) return "";
        String[] split = tokens.split("\\|");
        return simHash(Arrays.asList(split), tf);
    }

    public static String simHash(List<String> tokens, int tf) {
        if (tokens == null || tokens.size() == 0) return "";
        int[] v = new int[hashbits];
        Map<String, Integer> toptfs = getTopTfs(tokens, tf);
        for (String temp : toptfs.keySet()) {
            if (toptfs.get(temp) >= tf) {
                BigInteger t = hash(temp);
                for (int i = 0; i < hashbits; i++) {
                    BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                    if (t.and(bitmask).signum() != 0) {
                        v[i] += toptfs.get(temp);
                    } else {
                        v[i] -= toptfs.get(temp);
                    }
                }
            }
        }
        StringBuffer simHashBuffer = new StringBuffer();
        for (int i = 0; i < hashbits; i++) {
            if (v[i] >= 0) {
                simHashBuffer.append("1");
            } else {
                simHashBuffer.append("0");
            }
        }
        return simHashBuffer.toString();
    }

    public static BigInteger hash(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            System.out.println((((long) sourceArray[0]) << 7) + "----" + x);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(hashbits).subtract(
                    new BigInteger("1"));
            for (char item : sourceArray) {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }

    /**
     * 计算海明距离
     *
     * @param thisSimHash
     * @param other
     * @return
     */
    public static int hammingDistance(String thisSimHash, String other) {
        BigInteger thisfingerprint = new BigInteger("0");
        BigInteger otherfingerprint = new BigInteger("0");
        for (int i = 0; i < hashbits; i++) {
            if (Integer.parseInt(thisSimHash.charAt(i) + "") > 0) {
                thisfingerprint = thisfingerprint.add(new BigInteger("1").shiftLeft(i));
            } else {

            }
            if (Integer.parseInt(other.charAt(i) + "") > 0) {
                otherfingerprint = otherfingerprint.add(new BigInteger("1").shiftLeft(i));
            } else {

            }
        }
        BigInteger x = thisfingerprint.xor(otherfingerprint);
        int tot = 0;

        //统计x中二进制位数为1的个数
        //我们想想，一个二进制数减去1，那么，从最后那个1（包括那个1）后面的数字全都反了，对吧，然后，n&(n-1)就相当于把后面的数字清0，
        //我们看n能做多少次这样的操作就OK了。

        while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }


    /**
     * 确定使用哪些词进行hash
     * @param terms
     * @param tf tf阀值，大于该阀值的词，才进行hash
     * @return
     */
    private static Map<String, Integer> getTopTfs(List<String> terms, int tf) {
        Map<String, Integer> tfs = new Hashtable<String, Integer>();
        for (String term : terms) {
            if (tfs.containsKey(term)) {
                Integer frequency = tfs.get(term);
                frequency++;
                tfs.put(term, frequency);
            } else {
                tfs.put(term, 1);
            }
        }

        Map<String, Integer> topTFs = new Hashtable<String, Integer>();
        if (tfs != null) {
            for (Map.Entry<String, Integer> entry : tfs.entrySet()) {
                if (entry != null) {
                    if (entry.getValue() >= tf) {
                        topTFs.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return topTFs;
    }

	/*public static boolean isWeiboSite(OperatedInfo operatedInfo) {
		switch (operatedInfo.getSiteId()) {
			case 199://内网消息
				return true;
			case 200:
				return true;
			case 201:
				return true;
			case 207:
				return true;
			default:
				return false;
			}
	}*/

    /*	public static boolean isNewsSite(OperatedInfo operatedInfo) {
            switch (operatedInfo.getSiteId()) {
                case 202:
                    return true;
                case 203:
                    return true;
                case 204:
                    return true;
                case 206:
                    return true;
                case 208:
                    return true;
                default:
                    return false;
                }
        }
        */
    public static List<String> subByDistance(String hash) {
        int numEach = hashbits / (HAIMING_DISTANCE + 1);
        List<String> characters = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < hashbits; i++) {
            if (Integer.parseInt(hash.charAt(i) + "") > 0) {
                buffer.append("1");
            } else {
                buffer.append("0");
            }

            if ((i + 1) % numEach == 0) {
                characters.add(buffer.toString());
                buffer.delete(0, buffer.length());
            }
        }

        return characters;
    }

    public static BigInteger getBigintegerBysimhash(String simhash) {
        BigInteger fingerprint = new BigInteger("0");
        for (int i = 0; i < hashbits; i++) {
            if (Integer.parseInt(simhash.charAt(i) + "") > 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            } else {
            }
        }
        return fingerprint;
    }
}
