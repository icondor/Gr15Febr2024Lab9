package aplicatiimedicale;

import login.*;

public class A {

    public static void main(String[] args) {
        User u = new User("popescu", "abc");

        User u1 = new User("popescu", "abc");

//        if(u.equals(u1))
//            System.out.println("useri egali");
//        else
//            System.out.println("doi useri diferiti");


        System.out.println(u);

        u.setActive(true);

        System.out.println(u);

        //verific
        String pwd = u.getPassword();
        System.out.println(pwd);


    }
}
