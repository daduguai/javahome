package leetcode;

import utils.Print;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有单词 。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
*/
public class LeetCode151 {
    //使用栈存储字符串
    public static String reverseWords(String s){
        Stack<String>str=new Stack<String>();
        int i=0,j=0;
        for(;j<s.length();){
            if(s.charAt(i)==' '&&j!=s.length()-1){
                i++;
                if(i!=s.length()-1){
                    j++;
                }else{
                    if(s.charAt(i)!=' '){
                        String temp=s.substring(i,i+1);
                        str.push(temp);
                        j++;
                    }
                }

                continue;
            }
            if(s.charAt(j)==' '&&j!=i){
                String temp=s.substring(i,j);
                str.push(temp);
                i=j;
            }else if(s.charAt(j)!=' '&&j==s.length()-1){
                String temp=s.substring(i,j+1);
                str.push(temp);
            }
            j++;
        }

        String result="";
        while(!str.empty()){
            if(result.isEmpty()){
                result=str.peek();
                str.pop();
            }else{
                result=result+" "+str.peek();
                str.pop();
            }
        }
        //注意栈stack的遍历
//        for(int i=0;i<str.size();i++){
//            if(result.isEmpty()){
//                result=str.peek();
//                str.pop();
//            }else{
//                result=result+" "+str.peek();
//                str.pop();
//            }
//        }
        return result;
    }

    public static String reverseWords2(String s){
        if(s.isEmpty()){
            return s;
        }
        Stack<String>stack=new Stack<>();
        for(int i=0,j=0;i<s.length()&&j<s.length();){
            if(s.charAt(i)==' '){
                i++;
                j=i;
                continue;
            }
            if(s.charAt(j)!=' '){
                j++;
                if(j==s.length()){
                    String temp=s.substring(i,j);
                    stack.push(temp);
                }
                continue;
            }else{
                String temp=s.substring(i,j);
                stack.push(temp);
                i=j;
            }
        }
        String result="";
        while(!stack.empty()){
            if(result.isEmpty()){
                result=stack.peek();
                stack.pop();
            }else{
                result=result+" "+stack.peek();
                stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args){
        String s="  hello world  ";
        s=" asdasd df f";
        //s=" asdasd df f";
        //String rs=reverseWords(s);

        String rs=reverseWords2(s);
        Print.println(rs);
    }
}
