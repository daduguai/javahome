package leetcode;

import utils.Print;

//Manacher 算法
public class LeetCode5_02 {
    public static String longestPalindrome(String s){
        //假设字符串中不含字符$,使用$填充，将字符串变成奇数串
        if(s.isEmpty()||s.length()==1){
            return s;
        }
        String res="";
        String str="$";
        for(int i=0;i<s.length();i++){
            str=str+s.charAt(i)+"$";
        }
        Print.println(str);

        int[] mncher=new int[str.length()];
        mncher[0]=1;
        int length=1;
        int maxRight=0;//最右端
        int maxLenth=0;//记录最大长度
        int maxPos=0;
        int pos=0;//最长点坐标

        for(int i=0;i<str.length();i++){
            if(i<maxRight){
                mncher[i]=Math.min(mncher[2*pos-i],maxRight-i);
            }else{
                mncher[i]=1;
            }
            while(i-mncher[i]>=0&&i+mncher[i]<str.length()&&str.charAt(i+mncher[i])==str.charAt(i-mncher[i])){
                mncher[i]++;
            }
            if(mncher[i]+i-1>maxRight){
                maxRight=mncher[i]+i-1;
                pos=i;
            }
            if(mncher[i]>=maxLenth){
                maxLenth=mncher[i];
                maxPos=pos;
            }
        }
        res=s.substring(pos/2,2*maxLenth-1);
        return res;
    }

    public static void main(String[] args){
        longestPalindrome("abcdetf");
    }
}
