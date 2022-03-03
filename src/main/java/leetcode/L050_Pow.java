package leetcode;
/*pow(x,n)*/
public class L050_Pow {
    public double myPow(double x,int n){
        double res=0;
        long l_n=n;
        res=l_n>=0?quickCalc(x,l_n):1.0/quickCalc(x,-l_n);
        return res;
    }

    double quickCalc(double x,long n){
        double res=0;
        double ans=1;
        double x_contri=x;
        while(n>0){
            if(n%2==1){
                ans=ans*x_contri;
            }
            x_contri=x_contri*x_contri;
            n/=2;
        }


        return ans;
    }
}
