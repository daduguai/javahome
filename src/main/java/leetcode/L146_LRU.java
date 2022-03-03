package leetcode;

import java.util.HashMap;

public class L146_LRU {
    int size;
    int capacity;
    HashMap<Integer,LinkedNode>entity;
    LinkedNode head,tail;
    public L146_LRU(int capacity) {
        this.capacity=capacity;
        this.size=0;
        head.pre=null;
        head.next=null;
        tail.next=null;
        tail.pre=null;
    }

    public int get(int key) {
        if(entity.containsKey(key)){
            moveToHead(entity.get(key));
            return entity.get(key).data;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(head==null){
            head=new LinkedNode(key,value);
            tail=head;
            size++;
            return;
        }
        if(entity.containsKey(key)){
            entity.get(key).data=value;
            moveToHead(entity.get(key));
            return;
        }
        if(size==capacity){
            delete();
        }
        LinkedNode node=new LinkedNode(key,value);
        node.next= head;
        head.pre=node;
        head =node;
        entity.put(key,node);
        size++;
    }

    private void moveToHead(LinkedNode node){
        LinkedNode pre=null,next=null;
        if(node.pre!=null){
            pre=node.pre;
        }
        if(node.next!=null){
            next=node.next;
        }
        if(pre!=null&&next!=null){
            pre.next=next;
            next.pre=pre;
        }
        node.next= head;
        node.pre=null;
        head.pre=node;
        head =node;
    }

    private void delete(){
        if(head!=null){
            LinkedNode temp=tail.pre;
            temp.next=null;
            tail=temp;
        }
        size--;
    }
}
class LinkedNode{
    int data;
    int key;
    LinkedNode next;
    LinkedNode pre;
    public LinkedNode(int key,int data){
        this.key=key;
        this.data=data;
        next=null;
        pre=null;
    }
}
