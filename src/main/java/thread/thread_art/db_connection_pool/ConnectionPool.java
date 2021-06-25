package thread.thread_art.db_connection_pool;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection>pool=new LinkedList<Connection>();
    public ConnectionPool(int initialSize){
        if(initialSize>0){
            for(int i=0;i<initialSize;i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection!=null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    //获取数据库连接池，mills后超时返回，mills<0则一直等待
    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized (pool){
            if(mills<=0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeLast();
            }
            long future=System.currentTimeMillis()+mills;
            long remaining=mills;
            while(pool.isEmpty()&&remaining>0){
                pool.wait(mills);
                remaining=future-System.currentTimeMillis();
            }
            Connection result=null;
            if(!pool.isEmpty()){
                result=pool.removeLast();
            }
            return result;
        }
    }
}
