package leetcode;

public class L007_ReverseInteger {
    int reverseInteger(int x){
        int res=0;
        int mod;
        if(x>0){
            while(x!=0){
                mod=x%10;
                x=x/10;
                if(res<=Integer.MAX_VALUE/10&&mod<=Integer.MAX_VALUE%10){
                    res=res*10+mod;
                }else{
                    return 0;
                }
            }
        }else{
            while(x!=0){
                mod=x%10;
                x=x/10;
                if(res>=Integer.MIN_VALUE/10&&mod>=Integer.MIN_VALUE%10){
                    res=res*10+mod;
                }else{
                    return 0;
                }
            }
        }

        return res;
    }
}
