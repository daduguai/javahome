package algorithms.sequence;

//调表实现
public class SkipList {
    private static final float SKIPLIST_P=0.5f;
    private static final int MAX_LEVEL=16;
    private int levelCount=1;

    private Node head=new Node();
    public Node find(int value){
        return null;
    }
    public void insert(int value){}

    public void delete(int value){}



    public class Node{
        private int date=-1;
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
