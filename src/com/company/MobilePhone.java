package com.company;

import java.util.ArrayList;

/**
 * created by s.a.miroshnychenko 10/18/2018
 */

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldcontact, Contact newContact) {
        int foundPosition = findContact(oldcontact);
        if (foundPosition <= 0) {
            System.out.println(oldcontact.getName() + " , was not found");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldcontact.getName() + " was replased " + newContact.getName());
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
}