package leetcode;

public class L2164_SortEvenAndOdd {
    public int[] sortEvenAndOdd(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1, 0);
        quickSort(nums, 1, nums.length - 1, 1);
        return nums;
    }

    void quickSort(int[] nums, int left, int right, int odd) {
        int mid = getIndex(nums, left, right, odd);
        if (left >= right) {
            return;
        }
        quickSort(nums, left, mid - 1, odd);
        quickSort(nums, mid + 1, right, odd);
    }

    int getIndex(int[] nums, int left, int right, int odd) {
        int index;
        if (odd == 0) {
            int temp;
            int start=left,end=right;
            if (left % 2 == 0) {
                start=left;
                end=right;
            } else if (left % 2 == 1 && left + 1 <= right) {
                start=left+1;
                end=right;
            }
            temp=nums[start];
            int l=start,r=end%2==0?end:end-1;
            while(start<end){
                while(nums[r]>=temp&&r>start){
                    r=r-2;
                }
                while(nums[l]<=temp&&l<end){
                    l=l+2;
                }
                int t=nums[r];
                nums[r]=nums[l];
                nums[l]=t;
                start=l;
                end=r;
            }
            nums[start]=nums[l];
            nums[l]=temp;
            index=l;
        }else{
            int temp;
            int start=left,end=right;
            if (left % 2 == 0) {
                start=left+1;
                end=right;
            } else if (left % 2 == 1 && left + 1 <= right) {
                start=left;
                end=right;
            }
            temp=nums[start];
            int l=start,r=end%2==1?end:end-1;
            while(start<end){
                while(nums[r]>=temp&&r>start){
                    r=r-2;
                }
                while(nums[l]<=temp&&l<end){
                    l=l+2;
                }
                int t=nums[r];
                nums[r]=nums[l];
                nums[l]=t;
                start=l;
                end=r;
            }
            nums[start]=nums[l];
            nums[l]=temp;
            index=l;
        }
        return index;
    }
}
