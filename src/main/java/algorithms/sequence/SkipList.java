package algorithms.sequence;

//调表实现
public class SkipList {
    private static final float SKIPLIST_P=0.5f;
    private static final int MAX_LEVEL=16;
    private int levelCount=1;

    private Node head=new Node();
    public Node find(int value){
        Node p=head;
        for(int i=levelCount-1;i>=0;i++){
            while(p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
        }
        if(p.forwards[0]!=null&&p.forwards[0].data==value){
            return p.forwards[0];
        }else{
            return null;
        }
    }
    public void insert(int value){

    }

    public void delete(int value){}



    public class Node{
        private int data=-1;
        private Node forwards[]=new Node[MAX_LEVEL];
        private int maxLevel=0;

        @Override
        public String toString(){
            StringBuilder builder=new StringBuilder();
            builder.append("{data:");
            builder.append(data);
            builder.append("; levels:");
            builder.append(maxLevel);
            builder.append("}");
            return builder.toString();
        }
    }
}
