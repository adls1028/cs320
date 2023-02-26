/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.adls.contact.Contact;
import com.adls.contact.ContactService;

import static com.adls.contact.ContactService.uuid;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {

    @Test
    public void createUserWithContactIdLargerThanTen(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("99999999999","Billy", "Orange", "3136674567","849 Purple Street");                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Contact ID cannot be longer than 10 characters", thrown.getMessage());
    }
    @Test
    public void createUserWithContactIdNull(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact(null,"Billy", "Orange", "3136674567","849 Purple Street");                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Contact ID cannot be null", thrown.getMessage());
    }
    @Test
    public void createUserWithFirstNameLargerThanTen(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999","Pochahontas", "Orange", "3136674567","849 Purple Street");
                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("First name cannot be longer than 10 characters", thrown.getMessage());
    }
    @Test
    public void createUserWithFirstNameNull(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999",null, "Orange", "3136674567","849 Green Street");                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("First name cannot be null", thrown.getMessage());
    }
    @Test
    public void createUserWithLastNameLargerThanTen() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999", "Bob", "de los Santos", "8392019283", "123 Green Street");                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Last name cannot be longer than 10 characters", thrown.getMessage());
    }

    @Test
    public void createUserWithLastNameNull() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999", "Monty", null, "8291728374", "123 Bread Street");                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Last name cannot be null", thrown.getMessage());
    }

    @Test
    public void createUserWithPhoneNumberLargerThanTen(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999","Dakota", "Green", "8293829102938","123 Atlas Street");                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Phone number length invalid. It must be 10 digits", thrown.getMessage());
    }

    @Test
    public void createUserWithPhoneNumberNull(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999","Alessandro", "Chicken", null,"16 K Street");                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Phone Number cannot be null", thrown.getMessage());
    }

    @Test
    public void createUserWithPhoneNumberContainingLetters(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Contact c1 = new Contact("999","Alessandro", "de la Hoya", "N9512378Y6","123 Main Street");
                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Phone number cannot contain letters", thrown.getMessage());
    }


    @Test
    public void createUserWithAddressLargerThanThirty() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999", "Bob", "Green", "3136674567", "123 Main Street, Northampton Massachusetts");
                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Address cannot be longer than 30 characters", thrown.getMessage());
    }

    @Test
    public void createUserWithAddressNull() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {
                	Contact c1 = new Contact("999", "Steve", "Blue", "8882736501", null);
                    ContactService contactService = new ContactService();
                    System.out.println(ContactService.addContact(c1));
                });
        Assertions.assertEquals("Address cannot be null", thrown.getMessage());
    }

    @Test
    public void testSetterandGetter(){
        Contact c1 = new Contact(uuid," "," ","5556661234"," ");
        c1.setPhoneNumber("5555551111");
        c1.setAddress("123 Main Street");
        c1.setFirstName("Thomas");
        c1.setLastName("Magnum");
        System.out.println();
        System.out.println(c1.getPhoneNumber());
        System.out.println(c1.getAddress());
        System.out.println(c1.getFirstName());
        System.out.println(c1.getLastName());
    }
}
