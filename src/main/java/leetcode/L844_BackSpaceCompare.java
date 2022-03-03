package leetcode;

public class L844_BackSpaceCompare {
    public boolean backspaceCompare(String s, String t) {
        if(s.isEmpty()&&t.isEmpty()) {
            return true;
        }
        for(int i=s.length()-1,j=t.length()-1;i>=0||j>=0;){
            int space_s=0,space_t=0;
            while(i>=0){
                if(s.charAt(i)=='#'){
                    space_s++;
                    i--;
                }else if(space_s!=0){
                    space_s--;
                    i--;
                }else{
                    break;
                }
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    space_t++;
                    j--;
                }else if(space_t!=0){
                    space_t--;
                    j--;
                }else{
                    break;
                }
            }
            if(i>=0&&j>=0){
                if(s.charAt(i)!=t.charAt(j)){
                    return false;
                }
            }else{
                if(i>=0||j>=0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
