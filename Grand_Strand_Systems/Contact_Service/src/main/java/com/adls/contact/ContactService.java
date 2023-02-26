/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.contact;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.adls.contact.Contact.*;

/*
    The contact service shall be able to add contacts with a unique ID.
    The contact service shall be able to delete contacts per contact ID.
    The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
        -firstName
        -lastName
        -Number
        -Address
 */
public class ContactService {
    public static final String uuid = RandomStringUtils.random(uuidLength, letters, numbers);

    private static Map<String, Contact> contacts = new HashMap<String, Contact>();

   public static Map<String, Contact> addContact(Contact contact) {
       String uuid = ContactService.uuid;
       contacts.put(uuid, contact);
       return contacts;
   }

   public Map<String, Contact> deleteContact(String contactId) {
       Iterator itr = contacts.entrySet().iterator();

       while (itr.hasNext()) {
           Map.Entry<Integer, Contact> entry = (Map.Entry<Integer, Contact>) itr.next();
           if (entry.getValue().getContactId() == contactId) {
               itr.remove();
           }
       }
       return contacts;
   }

   public Map<String, Contact> updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
       Iterator itr = contacts.entrySet().iterator();

       while(itr.hasNext()){
           Map.Entry<Integer, Contact> entry = (Map.Entry<Integer, Contact>) itr.next();
           if(entry.getValue().getContactId() == contactId) {
               entry.getValue().setFirstName(firstName);
               entry.getValue().setLastName(lastName);
               entry.getValue().setPhoneNumber(phoneNumber);
               entry.getValue().setAddress(address);
           }
       }
       return contacts;
   }
}

