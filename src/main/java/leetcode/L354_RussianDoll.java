package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*俄罗斯套娃*/
public class L354_RussianDoll {
    public static int maxEnvelopes(int[][] envelopes) {
        int res=0;
        //方法一：排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int max=0;
        int[]cur=new int[2];
        int len=0;
        for(int i=0;i<envelopes.length;i++){
            len=0;
            for(int j=i;j<envelopes.length;j++){
                if(j==i){
                    cur=envelopes[j];
                    len++;
                }else{
                    if(envelopes[j][0]>cur[0]&&envelopes[j][1]>cur[1]){
                        cur=envelopes[j];
                        len++;
                    }
                }
            }
            if(len>max){
                max=len;
            }
        }
        return max;
    }
    public static void main(String[]args){
        int[][]envelopes={{5,4},{6,4},{6,7},{2,3}};
        maxEnvelopes(envelopes);
    }
    public static int maxEnvelopes2(int[][] envelopes){
        List<Integer> res=new ArrayList<>();
        Arrays.sort(envelopes,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];//当宽相等，则按照高度降序排序
                }else{
                    return o1[0]-o2[0];//按照宽度升序排序
                }
            }
        });

        res.add(envelopes[0][1]);
        for(int i=1;i<envelopes.length;i++){
            int num=envelopes[i][1];
            if(num>res.get(res.size()-1)){
                res.add(num);
            }else{
                int index=binarySearch(res,num);
                res.set(index,num);
            }
        }
        return res.size();
    }

    public static int binarySearch(List<Integer>res,int num){
        int i=0,j=res.size()-1;
        while(i<j){
            int mid=(i+j)/2;
            if(res.get(mid)<num){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return i;
}
}
