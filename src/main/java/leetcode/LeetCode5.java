package leetcode;
/**最长回文子串*/
public class LeetCode5 {
    public static String longestPalindrome(String s){
        String res="";
        if(s.isEmpty()||s.length()==1){
            return res;
        }
        int maxLength=0;
        for(int start=0;start<s.length();start++){
            for(int end=start;end<s.length();end++){
                if(s.charAt(start)==s.charAt(end)){
                    boolean flag=true;
                    for(int k=start;k<=end;k++){
                        if(s.charAt(k)!=s.charAt(start+end-k)){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        if(maxLength<=(end-start+1)){
                            maxLength=end-start+1;
                            res=s.substring(start,end+1);
                        }
                    }
                }
            }
        }

        return res;
    }
}
