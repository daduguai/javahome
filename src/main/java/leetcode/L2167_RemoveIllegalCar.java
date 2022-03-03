package leetcode;
/*最小步数移除非法车厢*/
public class L2167_RemoveIllegalCar {
    static int minimumRemoveIllegalCar(String s){
        int res;
        if(s==null||s.isEmpty()){
            res=0;
        }else{
            res=s.length();
            int pre=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    pre=Math.min(i+1,pre+2);
                }
                res=Math.min(res,pre+s.length()-i-1);
            }
        }

        return res;
    }
    public static void main(String[]args){
        String s="1100101";
        minimumRemoveIllegalCar(s);
    }
}
