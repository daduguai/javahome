package algorithms.sequence;

import java.util.LinkedList;

public class LRUExchangeImp implements CacheExchangeInterface<LinkNode>{
    public void exchange(LinkNode head){
    }
}
class LinkNode{
    private int data;
    private LinkNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}