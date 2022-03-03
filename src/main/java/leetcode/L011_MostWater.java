package leetcode;

public class L011_MostWater {
    /*若是height[i]==hieght[j]，该如何移动 */
    public int maxArea(int[] height) {
        int res=0;
        int i=0,j=height.length-1;
        if(height==null||height.length<=1){
            return res;
        }

        while(i<j){
            int temp=(j-i)*Math.min(height[i],height[j]);
            if(res==0){
                res=temp;
            }else{
                res=res>temp?res:temp;
            }
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }

        return res;
    }
}
