package leetcode;

import java.util.HashSet;
import java.util.Set;

/*字符串转换成整形*/
public class L008_Atoi {
    public static int myAtoi(String s) {
        Set set = new HashSet();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        int res = 0;
        String str = "";
        boolean isNegative = false;
        if (s == null || s.isEmpty()) {
            res = 0;
        } else {
            int i = 0;
            while (i < s.length() && (s.charAt(i) == ' ')) {
                i++;
            }
            if (i >= s.length()) {
                res = 0;
            } else {
                char t = s.charAt(i);
                if (t == '-') {
                    isNegative = true;
                    i++;
                } else if (t == '+') {
                    i++;
                }
                while (i < s.length() && set.contains(s.charAt(i))) {
                    str = str + s.charAt(i++);
                }

                int j = 0;
                while (j < str.length()) {
                    if(!isNegative&&(res>Integer.MAX_VALUE/10||res==Integer.MAX_VALUE/10&&(str.charAt(j)-'0')>Integer.MAX_VALUE%10)){
                        res=Integer.MAX_VALUE;
                        return res;
                    }
                    if(isNegative&&(-1*res<Integer.MIN_VALUE/10||-1*res==Integer.MIN_VALUE/10&&-1*(str.charAt(j)-'0')<Integer.MIN_VALUE%10)){
                        res=Integer.MIN_VALUE;
                        return res;
                    }
                    res = res * 10 + str.charAt(j) - '0';
                    j++;
                }
                if (isNegative) {
                    res = -1 * res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "2147483646";
        myAtoi(s);
    }
}
