package razvan;

import java.util.Scanner;

public class MainFixed {

    static Contact[] arrayOfContacts = new Contact[100];

    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        MainFixed main = new MainFixed();
        main.showMainMenuOptions();
    }


    public void showMainMenuOptions(){

        while(true) {
            System.out.println("________________________");
            System.out.println("Alegeti optiunea dorita:");
            System.out.println("1. Creeaza un contact");
            System.out.println("2. Afiseaza agenda");
            System.out.println("3. Modifica un contact");
            System.out.println("4. Sterge un contact");
            System.out.println("5. Cauta un contact");
            System.out.println("0. Inchide agenda");
            System.out.println("________________________");
            System.out.print("Optiune: ");
            String nrOptiune = s.nextLine();
            System.out.println("HERE");
            if (nrOptiune.equals("1"))
                createName();
            else if (nrOptiune.equals("2"))
                readNames();
            else if (nrOptiune.equals("3"))
                updateContact();
            else if (nrOptiune.equals("4"))
                deleteName();
            else if (nrOptiune.equals("5"))
                searchNumber();
            else if (nrOptiune.equals("0"))
                endProgram();
            else notFound();
        }
    }


    public void createName() {

        System.out.println("enter in create");

        System.out.println("Introdu numele: ");
        String name = s.nextLine();
        System.out.println("Introdu numarul: ");
        String number = s.nextLine();

        Contact newC = new Contact();
        newC.name = name;
        newC.number = number;


        for(int i = 0; i < arrayOfContacts.length; i++) {
            if(arrayOfContacts[i]==null) {
                arrayOfContacts[i] = newC;

                System.out.println("==========================");
                System.out.println("Contact adaugat cu succes!");
                System.out.println("==========================");
                //showMainMenuOptions();
                break;
            }
        }
    }

    /*private void testContacts() {
        for(int i = 0; i < 10; i++) {
            if(arrayOfContacts[i]==null) {
                arrayOfContacts[i].name = "Gheorghe" + (i + 1);
                arrayOfContacts[i].number = "0754" + i;
            }
        }
    }*/

    public void readNames() {
        showContactList();
        System.out.println();
       // showMainMenuOptions();
    }

    public void updateContact() {

        showContactList();

        System.out.println("Introduceti pozitia contactului: ");
        System.out.println("(tastati 0 pentru a anula)");
        int pozitia = Integer.parseInt(s.nextLine());

        if (pozitia < 0 || pozitia > (arrayOfContacts.length - 1)){
            notFound();
        } else if (pozitia == 0){
            showMainMenuOptions();
        } else {
            System.out.println(arrayOfContacts[pozitia - 1].name + " - " + arrayOfContacts[pozitia - 1].number);

            Contact newC = new Contact();

            // Modifica numele
            System.out.println("Introduceti alt nume: ");
            String name = s.nextLine();
            //arrayOfContacts[pozitia - 1].name = name;
            newC.name = name;

            // Modifica numarul
            System.out.println("Introduceti alt numar: ");
            String number = s.nextLine();
            //arrayOfContacts[pozitia - 1].number = number;
            newC.number = number;

            arrayOfContacts[pozitia - 1] = newC;


        }
        System.out.println();
        showContactList();
        System.out.println();
        showContactList();
    }

    public void deleteName() {
        showContactList();
        System.out.println("Introduceti pozitia contactului: ");
        System.out.println("(tastati 0 pentru a anula)");
        int pozitia = Integer.parseInt(s.nextLine());

        if (pozitia < 0 || pozitia > (arrayOfContacts.length - 1)){
            notFound();
        } else if (pozitia == 0){
            //showMainMenuOptions();

        } else {
            System.out.println("Sunteti sigur ca doriti sa stergeti contactul '" + arrayOfContacts[pozitia - 1].name + "' din agenda?");
            System.out.println("1 - DA");
            System.out.println("0 - NU");
            String raspuns = s.nextLine();
            if (raspuns.equals("1")){
                arrayOfContacts[pozitia - 1] = null;
                System.out.println("=========================");
                System.out.println("Contact sters din agenda!");
                System.out.println("=========================");
                //showMainMenuOptions();
            }
            else if (raspuns.equals("0")){
                deleteName();
            } else {
                notFound();
            }
        }
    }

    public void searchNumber() {
        System.out.println("Introduceti numarul");
        String numar = s.nextLine();
        boolean numarGasit = false;
        for(int i = 0; i < arrayOfContacts.length; i++) {
            if(arrayOfContacts[i] != null){
                if (arrayOfContacts[i].number.equals(numar)){
                    System.out.println("Contact gasit!");
                    System.out.println(arrayOfContacts[i].name + " - " + arrayOfContacts[i].number);
                    numarGasit = true;
                } else if (!numarGasit)
                    System.out.println("Numar negasit");
            }
        }
       // showMainMenuOptions();
    }
    public void showContactList(){
        if (arrayOfContacts[0] == null){
            System.out.println("==================");
            System.out.println("Agenda este goala!");
            System.out.println("==================");
          //  showMainMenuOptions();
        }

        int Counter = 0;

        for(int i = 0; i < arrayOfContacts.length; i++) {
            if(arrayOfContacts[i] != null){
                System.out.println((i + 1) + ". " + arrayOfContacts[i].name + " - " + arrayOfContacts[i].number);
                Counter++;
            }
        }
        System.out.println("Lungime array: " + Counter);
    }

    public void notFound(){
        System.out.println("================");
        System.out.println("Optiune invalida!");
        System.out.println("================");
      //  showMainMenuOptions();
    }

    public static void endProgram(){
        System.out.println("==========");
        System.out.println("O zi buna!");
        System.out.println("==========");
        System.exit(0);
    }
}