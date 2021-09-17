package algorithms.Sort;

public class HeapSort implements SortInterface {
    private int[]data;
    private int size=0;//当前堆的大小
    private int height;//最大的堆大小
    //默认大根堆，使用数组实现
    @Override
    public void sortAsc(int[] data){

    }
    //往堆中插入一个元素
    public void insert(int[]data,int key){
        //空堆情况
        if(size<=0){
            data=new int[1];
            data[0]=key;
            size++;
            return;
        }
        //堆满情况
        if(size>=height){
            data=new int[2*height];
            /**
             * 迁移*/
            height=2*height;
        }

        data[size+1]=key;//插入最后一个节点位置
        //堆化
        int pos=size+1;
        while(pos>0){
            if(data[pos]>data[pos/2]){
                int temp=data[pos/2];
                data[pos/2]=data[pos];
                data[pos]=temp;
                pos=pos/2;
            }else{
                break;
            }
        }

    }
}
