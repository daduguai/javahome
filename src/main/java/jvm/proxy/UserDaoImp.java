package jvm.proxy;

import utils.Print;

public class UserDaoImp implements UserDao {

    public void add(){
        Print.println("添加功能");
    }
    public void delete(){
        Print.println("删除功能");
    }
    public void update(){
        Print.println("更新功能");
    }
    public void find(){
        Print.println("查找功能");
    }

}
