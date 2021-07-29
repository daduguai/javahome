package leetcode;

import utils.Print;

//Manacher 算法
public class LeetCode5_02 {
    public static String longestPalindrome(String s){
        //假设字符串中不含字符$,使用$填充，将字符串变成奇数串
        String res=null;
        String str="$";
        for(int i=0;i<s.length();i++){
            str=str+s.charAt(i)+"$";
        }
        Print.println(str);


        return res;
    }

    public static void main(String[] args){
        longestPalindrome("abcdetf");
    }
}
