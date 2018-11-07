package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("00393304404");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter Actions ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shuting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateConatct();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryConatct();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }

    }

    private static void addNewContact() {
        System.out.println("Enter new contact name");
        String name = scanner.nextLine();
        System.out.println("Enter new contact name");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added " + name + " phone " + number);
        }
        else {
            System.out.println("Cannot add " + name + " alredy on file");
        }

    }

    private static void startPhone() {
        System.out.println("Starting phone");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 to print contacts\n" +
                "2 to add contacts\n" +
                "3 to update contacts\n" +
                "4 to remove contacts\n" +
                "5 query if an existing contact exist\n" +
                "6 to print list of available actions \n");
        System.out.println("Choose your action");
    }
}
