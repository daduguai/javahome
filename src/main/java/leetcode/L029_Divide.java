package leetcode;
/*两数相除*/
/*思路：采用二分法*/
public class L029_Divide {
    public static int divide(int dividend,int divisor){
        if(dividend==0){
            return 0;
        }
        long res=Integer.MAX_VALUE;
        long i=0;
        long divd_long=Math.abs((long)dividend);
        long divr_long=Math.abs((long)divisor);
        if(divd_long<divr_long){
            return 0;
        }
        long d_temp=divr_long;
        boolean neg=true;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)){
            neg=false;
        }
        while(d_temp<=divd_long){
            if(d_temp+d_temp<=divd_long){
                if(i==0){
                    i=2;
                }else{
                    i=i+i;
                }
                d_temp=d_temp+d_temp;
            }else{
                if(i==0){
                    i=2;
                }else{
                    i=i+1;
                }
                d_temp=d_temp+divr_long;
            }
        }
        i=i-1;
        if(i>res&&!neg){
            return (int)res;
        }
        if(neg){
            res=0-i;
        }else{
            res=i;
        }
        return (int)res;
    }

    public static void main(String[]args){
        int dividend=1;
        int divisor=1;
        divide(dividend,divisor);
    }
}
