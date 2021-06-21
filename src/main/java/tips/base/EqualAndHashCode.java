package tips.base;

import utils.Print;

public class EqualAndHashCode {
    public static void main(String[] args){
        String a=new String("ab");//a为引用
        String b=new String("ab");//b为另一个引用，对象的内容一样
        String aa="ab";//常量池
        String bb="ab";

        if(aa==bb){
            Print.println("aa==bb");
        }
        if(a==b){
            Print.println("a==b");
        }
        if(a.equals(b)){
            Print.println("aEQb");
        }
        if(42==42.0){
            Print.println("true");
        }
    }
}
