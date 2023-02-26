package com.adls.contact;

import org.junit.jupiter.api.Test;

import static com.adls.contact.ContactService.uuid;

public class ContactServiceTest {

    @Test
    public void createModifyAndDeleteUser(){
        Contact c1 = new Contact(uuid, "Bob", "Chicken","4258942938","57 Pumpkin Street");

        ContactService contactService = new ContactService();

        System.out.println(contactService.addContact(c1));
        System.out.print(contactService.updateContact(uuid,"Bob","Salad","8392850593","40224 Highway 7"));
        System.out.print(contactService.deleteContact(uuid));

    }
}
