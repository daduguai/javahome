package leetcode;
//盛最多水的容器
/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class LeetCode11 {
    //暴力法
    public int maxArea(int[] height) {
        if(height.length<=1){
            return 0;
        }
        int res=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                if(i==0&&j==1){
                    res=Math.min(height[i],height[j]);
                }else{
                    int temp=Math.min(height[i],height[j])*(j-i);
                    res=Math.max(res,temp);
                }
            }
        }
        return res;
    }

    //暴力法
}
