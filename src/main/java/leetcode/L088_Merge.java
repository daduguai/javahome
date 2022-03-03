package leetcode;
/*合并两个有序数组*/
public class L088_Merge {
    void merge(int[]nums1,int m,int[]nums2,int n){
        int index1=m-1;
        int index2=n-1;
        int len1=m+n-1;
        while(index1>=0&&index2>=0){
            if(nums1[index1]>=nums2[index2]){
                nums1[len1--]=nums1[index1];
                index1--;
            }else{
                nums1[len1--]=nums2[index2];
                index2--;
            }
        }
        if(index1<0){
            for(int i=index2;i>=0;i--){
                nums1[len1--]=nums2[i];
            }
        }
    }
}
