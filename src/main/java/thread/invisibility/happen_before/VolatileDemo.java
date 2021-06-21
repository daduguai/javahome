package thread.invisibility.happen_before;

import utils.Print;

public class VolatileDemo {
    int x=0;
    volatile boolean v=false;
    public void writer(){
        x=42;
        v=true;
    }
    public void reader(){
        if(v==true){
            Print.println("x="+x+",v="+v);
        }else{
            Print.println("x="+x+",v="+v);
        }
    }
}
