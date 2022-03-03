package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*区间列表交集*/
public class L986_Intersection {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res=new ArrayList<>();
        int k = 0;
        for (int i = 0, j = 0; i < firstList.length && j < secondList.length; ) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            if (first[1] < second[0] || second[1] < first[0]) {
                ;
            } else {
                int left = Math.max(first[0], second[0]);
                int right = Math.min(first[1], second[1]);
                int[]arr=new int[]{left, right};
                res.add(arr);
            }
            if (first[1] < second[1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        intervalIntersection(firstList, secondList);
    }
}
