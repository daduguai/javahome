package algorithms.Sort;

public class QuickSort implements SortInterface {
    @Override
    public  void sortAsc(int[]data){
        int mid=0;
        if(data==null||data.length==0){
            return;
        }
        quickSort(data,0,data.length-1);
    }

    private void quickSort(int[] data,int start,int end){
        if(start>=end){
            return;
        }
        int mid=partition(data,start,end);
        quickSort(data,start,mid-1);
        quickSort(data,mid+1,end);
    }

    private int partition(int[]data,int start,int end){
        int i=start,j=end;
        int temp=data[end];
        while(i<j){
            while(i<j){
                if(data[i]<=temp){
                    i++;
                }else{
                    break;
                }
            }
            while(i<j){
                if(data[j]>=temp){
                    j--;
                }else{
                    break;
                }
            }
            int middle=data[i];
            data[i]=data[j];
            data[j]=middle;
        }
        int m=data[i];
        data[i]=temp;
        data[end]=m;
        return i;
    }
}
