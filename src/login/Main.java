package login;

import login.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User uu;
        User u1 = new User("ion", "password1"); // il nasc, constructor , constructor implicit
        System.out.println("primul user "+u1);


        User u2 = new User("maria"); // il nasc
        u2.setActive(false);
        System.out.println("al doilea user "+u2);





//        String[] validUsernames = {"user1", "user2", "user3"};
//        String[] validPwd = {"a", "b", "c"};
//        boolean[] userOK = {true, false, true};

        User[] dbUsers = new User[2];
        dbUsers[0]=u1;
        dbUsers[1]=u2;



        int maxAttempts = 3;
        int currentAttempts = 0;
        boolean loginSuccessful = false;


        Scanner scanner = new Scanner(System.in);




        do {

            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();
            System.out.print("Enter pwd: ");
            String  p = scanner.nextLine();



            for (int i = 0; i < dbUsers.length; i++) {

                // scot din array
                User userCurent = dbUsers[i];
                System.out.println(userCurent);
                if (userCurent.getUsername().equals(enteredUsername) && userCurent.getPassword().equals(p) && userCurent.isActive()) {
                    loginSuccessful = true;
                    break;
                }
            }

            if (loginSuccessful) {
                System.out.println("Login successful!");
                dummy();
            } else {
                currentAttempts++;
                System.out.println("Invalid username or password. Login failed.");
                if (currentAttempts < maxAttempts) {
                    System.out.println("Try again. Attempts left: " + (maxAttempts - currentAttempts));
                } else {
                    System.out.println("Maximum attempts reached. Exiting program.");
                }
            }
        } while (!loginSuccessful && currentAttempts < maxAttempts);
    }

    private static void dummy() {
        System.out.println("Welcome to the dummy method!");
        // Add your logic for the dummy method here
    }
}
