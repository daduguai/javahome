package algorithms.Sort;

public class InsertSort implements SortInterface {
    @Override
    public void sortAsc(int[] data){
        if(data==null&&data.length==0){
            return;
        }
        for(int i=1;i<data.length;i++){
            int temp=data[i];
            for(int j=i-1;j>=0;j--){
                if(temp<data[j]){
                    data[j+1]=data[j];
                }else{
                    break;
                }
                data[j+1]=temp;
            }
        }
    }
}
