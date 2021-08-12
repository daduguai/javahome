package leetcode;

import utils.Print;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数
 */

public class LeetCode8 {
    public static int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String temp1 = "";
        boolean firstEmpty=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '&&!firstEmpty){
                firstEmpty=false;
            }else{
                firstEmpty=true;
                temp1=temp1+s.charAt(i);
            }
        }
        String temp="";
        boolean flag = false;//标识是否是负数，true表示负数
        for (int i = 0; i < temp1.length(); i++) {
            if (i == 0 && temp1.charAt(i) == '-') {
                flag = true;
            } else if (i == 0 && temp1.charAt(i) == '+') {
                continue;
            } else if (temp1.charAt(i) > '9' || temp1.charAt(i) < '0') {
                break;
            } else {
                temp = temp + temp1.charAt(i);
            }
        }
        if (temp.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (!flag && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && (temp.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                res = Integer.MAX_VALUE;
                break;
            } else if (flag && (((-1 * res) < Integer.MIN_VALUE / 10) || ((-1 * res) == Integer.MIN_VALUE / 10) && (-1 * (temp.charAt(i) - '0')) < Integer.MIN_VALUE % 10)) {
                res = Integer.MIN_VALUE;
                break;
            } else {
                res = res * 10 + temp.charAt(i) - '0';
            }
        }
        if (flag && res != Integer.MIN_VALUE) {
            res = -1 * res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "4193 hello";
        s = "-91283472332";
        s = "+-15";
        s = "-15";
        s = "+2";
        s="   +0 123";
        int res = myAtoi(s);
        Print.println(res);
    }
}
