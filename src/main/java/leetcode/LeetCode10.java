package leetcode;
/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * */
public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        if(s.isEmpty()&&p.isEmpty()){
            return true;
        }
        boolean res=true;
        for(int i=0,j=0;i<s.length()&&j<p.length();){
            char a=s.charAt(i);
            char b=p.charAt(j);
            if(a==b){
                i++;
                j++;
            }else{
                if(b=='.') {//针对.符号的处理
                    i++;
                    j++;
                    continue;
                }
                if(b=='*'&&j>=1){//针对*号的处理
                    char c=s.charAt(j-1);
                    if(a==c){
                        i++;
                        j++;
                    }else{

                    }
                }
            }
        }
        return res;
    }
}
