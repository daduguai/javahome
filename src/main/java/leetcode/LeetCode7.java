package leetcode;

import utils.Print;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 **/
public class LeetCode7 {
    public static int reverse(int x) {
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int t=0;
        int shang=0;
        int yushu=0;
        while(x!=0){
            if(t>max/10||t<min/10){//注意溢出判断
                return 0;
            }
            yushu=x%10;
            t=t*10+yushu;
            x=x/10;
        }
        return t;
    }

    public static void main(String[] args){
        int x=1534236469;
        //int x=123;
        int res=reverse(x);
        Print.println(res);
    }
}
