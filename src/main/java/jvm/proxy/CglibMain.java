package jvm.proxy;

import net.sf.cglib.proxy.Enhancer;
import utils.Print;

public class CglibMain {

    public static void main(String[] args){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new UserDaoCglib());

        UserDao obj2=(UserDao)enhancer.create();
        System.out.println(obj2);
        obj2.add();
        obj2.delete();
        obj2.update();
        obj2.find();
    }
}
