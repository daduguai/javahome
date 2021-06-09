package thread.singleton;

import utils.Print;

import java.io.*;

public class AntiSerializeRun {
    public static void main(String[] args){
        try{
            FullSingleton myObject =FullSingleton.getInstance();
            Print.println(myObject.hashCode());
            FileOutputStream fosRef=new FileOutputStream(new File("myObjectFile1.txt"));
            ObjectOutputStream oosRef=new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            Print.println(myObject.hashCode());
            oosRef.close();
            fosRef.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            FileInputStream fisRef=new FileInputStream(new File("myObjectFile1.txt"));
            ObjectInputStream iosRef=new ObjectInputStream(fisRef);
            FullSingleton myObject=(FullSingleton)iosRef.readObject();
            Print.println(myObject.hashCode());
            iosRef.close();
            fisRef.close();
            Print.println(myObject.hashCode());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
//其他几种模式不可序列化，静态内部类可序列化