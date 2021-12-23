package jvm.proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {

    public static void main(String[] args){

        UserDao userDaoImp=new UserDaoImp();
        ClassLoader classLoader=userDaoImp.getClass().getClassLoader();
        Class<?>[] interfaces=userDaoImp.getClass().getInterfaces();
        MyInvocationHandler handler=new MyInvocationHandler(userDaoImp);
        UserDao proxy=(UserDao)Proxy.newProxyInstance(classLoader,interfaces,handler);
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.find();
    }
}
