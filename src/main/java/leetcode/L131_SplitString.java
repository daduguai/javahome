package leetcode;

import java.util.ArrayList;
import java.util.List;

/*分割字符串*/
public class L131_SplitString {
    public List<List<String>> partition(String s){
        List<List<String>>res=new ArrayList<>();
        if(s==null||s.isEmpty()){
            return res;
        }
        char[]ch=s.toCharArray();
        dfs(ch,0,new ArrayList<String>(),res);
        return res;
    }
    public void dfs(char[]ch,int idx,List<String>str,List<List<String>>res){
        if(idx==ch.length){
            res.add(new ArrayList<>(str));
            return;
        }
        for(int i=idx;i<ch.length;i++){
            if(!isPalindrome(ch,idx,i)){
                continue;
            }
            str.add(new String(ch,idx,i+1-idx));
            dfs(ch,i+1,str,res);
            str.remove(str.size()-1);
        }
    }
    public boolean isPalindrome(char[]s,int i,int j){
        if(s==null||s.length<=1){
            return true;
        }
        while(i<j){
            if(s[i]!=s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
