package offer;
/*整数除法*/
public class L001_IntegerDivide {
    static int divide(int a,int b){
        int res=0;
        int i=0,sum=0;
        int neg_a=a>0?-1*a:a;
        int neg_b=b>0?-1*b:b;
        while(sum>=neg_a){
            if(Integer.MIN_VALUE-sum-neg_b>=0){
                if(i<Integer.MAX_VALUE){
                    i++;
                }else{
                    i=Integer.MAX_VALUE;
                    return i;
                }
                break;
            }else{
                sum=sum+neg_b;
                if(i<Integer.MAX_VALUE){
                    i++;
                }else{
                    i=Integer.MAX_VALUE;
                    return i;
                }
            }
        }
        if(i>0){
            i--;
        }
        if(a>0&&b<0||a<0&&b>0){
            i=-1*i;
        }
        res=i;
        return res;
    }
    public static void main(String[]args){
        int a=-2147483648,b=1;
        a=Math.abs(a);
        divide(a,b);
    }
}
