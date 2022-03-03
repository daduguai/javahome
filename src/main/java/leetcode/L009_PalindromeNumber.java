package leetcode;

public class L009_PalindromeNumber {
    public boolean isPalindromeNumber(int x){
        boolean res=false;
        if(x<0){
            res=false;
        }else{
            int rs=0;
            while(x!=0){
                int mod=x%10;
                int div=x/10;
                if(rs<Integer.MAX_VALUE/10||rs==Integer.MAX_VALUE/10&&mod<=Integer.MAX_VALUE%10){
                    rs=rs*10+mod;
                }else{
                    return false;
                }
            }
            if(rs==x){
                return true;
            }
        }
        return res;
    }
}
