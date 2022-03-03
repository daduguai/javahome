package leetcode;

import java.util.ArrayList;
import java.util.List;

/*字母异位词分组*/
public class L049_DiffPosition {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        if(strs==null||strs.length==0){
            return res;
        }
        boolean[] visited=new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(visited[i]){
                continue;
            }
            List<String>list=new ArrayList<>();
            String str=strs[i];
            list.add(str);
            visited[i]=true;
            for(int j=i+1;j<strs.length;j++){
                String temp=strs[j];
                if(visited[j]||str.length()!=temp.length()){
                    continue;
                }
                if(isAnagram(str,temp)){
                    list.add(temp);
                    visited[j]=true;
                }
            }
            res.add(list);
        }
        return res;
    }
    boolean isAnagram(String str1,String str2){
        if(str1.isEmpty()&&str1.isEmpty()){
            return true;
        }
        if(str1.length()!=str2.length()){
            return false;
        }
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        for(int i=0;i<26;i++){
            arr1[i]=0;
            arr2[i]=0;
        }

        for(int i=0;i<str1.length();i++){
            char s=str1.charAt(i);
            char d=str2.charAt(i);
            arr1[s-'a']=arr1[s-'a']+1;
            arr2[d-'a']=arr2[d-'a']+1;
        }
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
