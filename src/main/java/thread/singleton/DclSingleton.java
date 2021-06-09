package thread.singleton;

//双重判空单例
public class DclSingleton {
    private static DclSingleton dclSingleton;

    private DclSingleton() {
    }

    public static DclSingleton getInstance() {
        try{
            if (dclSingleton != null){}
            Thread.sleep(3000);
            synchronized (DclSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DclSingleton();
                }

            }
        }catch (InterruptedException e){

        }
        return dclSingleton;
    }
}
