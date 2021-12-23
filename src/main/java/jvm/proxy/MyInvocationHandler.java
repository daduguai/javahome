package jvm.proxy;

import utils.Print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object object;

    public MyInvocationHandler(Object object){
        this.object=object;
    }

    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        Print.println("权限校验");
        Object result=method.invoke(object,args);
        Print.println("日志打印");
        return result;
    }

}
