package thread.singleton;

import utils.Print;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum EnumSingleton {
    connectionFactory;
    private Connection connection;
    private EnumSingleton(){
        try{
            Print.println("调用构造方法");
            String url="jdbc:sqlserver://localhost:1079;databaseName=ghydb";
            String userName="sa";
            String passWord="";
            String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driverName);
            connection= DriverManager.getConnection(url,userName,passWord);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
