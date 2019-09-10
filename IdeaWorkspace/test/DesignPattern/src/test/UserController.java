package test;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class UserController {

    public String register(String username, String password){
        System.out.println(username + password);

        String str = new String();
        WeakReference<String> softReference = new WeakReference<>(str);

        return "success";
    }

}
