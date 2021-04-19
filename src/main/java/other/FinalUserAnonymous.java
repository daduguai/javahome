package other;

import utils.Print;

//匿名类中访问局部变量，局部变量需要时final
public class FinalUserAnonymous {
    public void finalUserAnonymousInterface(){
        final Integer number=123;
        Print.println(number);

        FinalQuestionInterface myInmp=new FinalQuestionInterface(){
            public void doSomething(){
                Print.println(number);
            }
        };
        myInmp.doSomething();
        Print.println(number);
    }
}
