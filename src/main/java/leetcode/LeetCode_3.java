package leetcode;

import utils.Print;

/**
 * leetcode3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。*/
public class LeetCode_3 {
    public static int lengthOfLongestSubstring(String s) {
        int res=0;
        if(s.isEmpty()){
            res=0;
        }
        else if(s.length()==1){
            res=1;
        }else{
            int start=0, end=0;
            int i=1;
            while(i<s.length()){
                int index=-1;
                for(int k=start;k<=end;k++){
                    if(s.charAt(i)==s.charAt(k)){
                        index=k+1;
                    }
                }
                if(index==-1){
                    end=i;
                }else{
                    start=index;
                    end=i;
                }
                res=end-start+1>res?end-start+1:res;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s="  ";
        int res=lengthOfLongestSubstring(s);
        Print.println(res);
    }
}

/**
 * 思路：
 * 滑动窗口：使用两个指针记录开始结束位置，时间复杂度:O(n2),使用hashset存储最长的字串，时间复杂度：O(n)*/