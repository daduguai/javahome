package leetcode;
/*快乐前缀字符串*/
public class L1392_HappyPrefix {
    String happyPrefix(String s){
        String res="";
        if(s==null||s.length()<=1){
        return res;
    }
        for(int i=1;i<s.length();i++){
        if(s.charAt(i)==s.charAt(0)){
            int start1=0,start2=i;
            while(start2<s.length()){
                if(s.charAt(start1)==s.charAt(start2)){
                    start1++;
                    start2++;
                }else{
                    break;
                }

            }
            if(start2==s.length()){
                res=s.substring(0,start1);
                return res;
            }
        }
    }
    return res;
}
}
