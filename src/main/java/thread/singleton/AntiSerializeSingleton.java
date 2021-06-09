package thread.singleton;

import utils.Print;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class AntiSerializeSingleton implements Serializable {
    private static final long serialVersionUID=888L;
    private static class MyObjectHandler{
        private static final AntiSerializeSingleton instance=new AntiSerializeSingleton();
    }
    private AntiSerializeSingleton(){}

    public static AntiSerializeSingleton getInstance(){
        return MyObjectHandler.instance;
    }

    protected Object readResolve() throws ObjectStreamException{
        Print.println("调用了readResolve方法");
        return MyObjectHandler.instance;
    }
}
