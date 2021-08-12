package leetcode;

import utils.Print;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class LeetCode14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if(strs.length==1){
            return strs[0];
        }
        String res = "";
        for (int i = 0; i < strs[0].length(); i++) {
            boolean t = false;
            for (int j = 0; j < strs.length - 1; j++) {
                if (i < strs[j].length()&&i<strs[j+1].length()) {
                    if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                        t = true;
                    } else {
                        t=false;
                        break;
                    }
                }else{
                    t=false;
                    break;
                }
            }
            if (t) {
                res = res + strs[0].charAt(i);
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[]args){
        //String[]str={"flower","flow","flight"};
        //String[]str={"s"};
        String[]str={"ab", "a"};
        String res=longestCommonPrefix(str);
        Print.println(res);
    }

}
