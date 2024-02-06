package login;

public class Ex2 {
    public static void main(String[] args) {

        int y = 0;
        while(true) {
            System.out.println("intra in for cu y= "+y);
            if(y>=10) {
                System.out.println("iese cu break si y este" +y);
                break;}

            System.out.println("y inainte "+y);
            y+=++y;
            System.out.println("y dupa "+y);
            }


        System.out.println("y dupa "+y);
        }


    }

