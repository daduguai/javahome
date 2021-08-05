package algorithms.Sort;

import utils.Print;

public class Run {
    public static void main(String[] args){
        int[] data={6,5,4,3,2,1};
        Print.println("Before:");
        for(int i=0;i<data.length;i++){
            Print.println(data[i]);
        }
        SortInterface sort=new QuickSort();
        sort.sortAsc(data);
        Print.println("After:");
        for(int i=0;i<data.length;i++){
            Print.println(data[i]);
        }
    }
}
