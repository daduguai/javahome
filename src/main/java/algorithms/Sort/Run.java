package algorithms.Sort;

import utils.Print;

public class Run {
    public static void main(String[] args){
        int[] data={1,4,6,3,5,6};
        Print.println("Before:");
        for(int i=0;i<data.length;i++){
            Print.println(data[i]);
        }
        SortInterface sort=new SelectSort();
        sort.sortAsc(data);
        Print.println("After:");
        for(int i=0;i<data.length;i++){
            Print.println(data[i]);
        }
    }
}
