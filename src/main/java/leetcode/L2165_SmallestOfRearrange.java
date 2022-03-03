package leetcode;

import java.util.HashMap;
import java.util.Map;

/*重排数字的最小值*/
public class L2165_SmallestOfRearrange {
    static long getSmallestOfRearrange(long num) {
        if (num == 0) {
            return num;
        }
        long res;
        String str = String.valueOf(num);
        char[] ch = str.toCharArray();
        res = sort(ch);
        return res;
    }

    static long sort(char[] ch) {
        if (ch[0] == '-') {
            HashMap<Character, Integer> map = new HashMap();
            for (int i = 1; i < ch.length; i++) {
                if (map.containsKey(ch[i])) {
                    int val = map.get(ch[i]);
                    map.put(ch[i], ++val);
                } else {
                    map.put(ch[i], 1);
                }
            }
            int index = 1;
            for (char c = '9'; c >= '0'; c--) {
                if (map.containsKey(c)) {
                    int val = map.get(c);
                    for (int i = 0; i < val; i++) {
                        ch[index++] = c;
                    }
                }
            }
            String str = new String(ch);
            return Long.valueOf(str);
        } else {
            HashMap<Character, Integer> map = new HashMap();
            for (int i = 0; i < ch.length; i++) {
                if (map.containsKey(ch[i])) {
                    int val = map.get(ch[i]);
                    map.put(ch[i], ++val);
                } else {
                    map.put(ch[i], 1);
                }
            }
            int index = 0;
            for (char c = '0'; c <= '9'; c++) {
                if (map.containsKey(c)) {
                    int val = map.get(c);
                    for (int i = 0; i < val; i++) {
                        ch[index++] = c;
                    }
                }
            }
            int firstNotZero = 0;
            int i = 0;
            for (; i < ch.length; i++) {
                if (ch[i] != '0') {
                    break;
                }
            }
            if (i != 0) {
                char t = ch[i];
                ch[i] = '0';
                ch[0] = t;
            }
            String str = new String(ch);
            return Long.valueOf(str);
        }

    }

    public static  void main(String[]args){
        long num=-2770;
        long t=getSmallestOfRearrange(num);
    }
}
