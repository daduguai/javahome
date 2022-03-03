package leetcode;
/*Z字形变换*/
public class L006_ZDispay {
    public static String convert(String s, int numRows) {
        if(s==null||s.isEmpty()){
            return s;
        }
        if(s.length()<=numRows||numRows==1){
            return s;
        }
        String res="";
        for(int i=0;i<numRows;i++){
            int k=0;
            for(k=0;2*k*(numRows-1)-i<s.length()||2*k*(numRows-1)+i<s.length();k++){
                if(i==0){
                    res=res+s.charAt(2*k*(numRows-1));
                }else if(i==numRows-1){
                    int coor=(2*k+1)*(numRows-1);
                    if(coor<s.length()){
                        res=res+s.charAt((coor));
                    }
                }else{
                    int left=2*k*(numRows-1)-i;
                    int right=2*k*(numRows-1)+i;
                    if(left>=0){
                        res=res+s.charAt(left);
                    }
                    if(right<s.length()&&right>=0){
                        res=res+s.charAt(right);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[]args){
        String str="PAYPALISHIRING";
        int height=3;
        convert(str,height);
    }
}
