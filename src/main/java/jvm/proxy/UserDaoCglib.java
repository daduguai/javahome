package jvm.proxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Enhancer;

import thread.sync_security.ObjectService;
import utils.Print;

import java.lang.reflect.Method;

public class UserDaoCglib implements MethodInterceptor {
   public Object intercept(Object obj,Method method,Object[]params,MethodProxy proxy)throws Throwable{
       Print.println("cglib权限校验");
       Object result=proxy.invokeSuper(obj,params);
       Print.println("cglib日志校验");
       return result;
   }
}
