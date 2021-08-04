package algorithms.Sort;

public class SelectSort implements SortInterface{
    @Override
    public void sortAsc(int[] data){
        if(data==null||data.length==0){
            return;
        }
        for(int i=0;i<data.length;i++){
            int temp=data[i];
            int k=i;
            for(int j=i+1;j<data.length;j++){
                if(data[j]<temp){
                    temp=data[j];
                    k=j;
                }
            }
            data[k]=data[i];
            data[i]=temp;
        }
    }
}
