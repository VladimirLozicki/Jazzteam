package org.jazzteam.singleton;
import mylist.*;
public class Singleton extends  MyList{

    private static Singleton instance;

    private  Singleton() {
        super();
    }

    public  static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


}
