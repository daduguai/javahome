package leetcode;

import java.util.HashMap;
import java.util.Map;

/*整数转罗马数字*/
public class L012_IntToRoman {
    public String intToRoman(int num){
        String res=null;
        Map<Integer,String> map=new HashMap<>();
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        int thousand=num/1000;
        if(thousand>=1){
            for(int i=0;i<thousand;i++){
                res=res+"M";
            }
        }
        int hundred=num%1000/100;
        if(hundred>=1){
            if(hundred==9){
                res=res+"CM";
            }else if(hundred==4){
                res=res+"CD";
            }else {
                if(hundred>=0&&hundred<4){
                    for(int i=0;i<hundred;i++){
                        if(i==0){
                            res=res+"C";
                        }else{
                            res=res+"L";
                        }
                    }
                }else if(hundred>=5&hundred<9){
                    for(int i=5;i<hundred;i++){
                        if(i==5){
                            res=res+"D";
                        }else{
                            res+="C";
                        }
                    }
                }
            }
        }
        int shiwei=num%1000%100/10;

        return res;
    }
    public String intToRoman2(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String res="";
        for(int i=0;i<values.length;i++){
            String symbol=symbols[i];
            while(num>=values[i]){
                res=res+symbol;
                num=num-values[i];
            }
            if(num==0){
                break;
            }
        }
        return res;
    }
}
