/*
 * Copyright (c) 2023 Amanda de los Santos
 */

package com.adls.contact;

public class Contact {

    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    static boolean numbers = true;
    static boolean letters = true;
    public static int uuidLength = 10;
    private int phoneNumLength = 10;
    private int lastNameLength = 10;
    private int firstNameLength = 10;
    private int addressLength = 30;


    public Contact(String contactId,  String firstName, String lastName, String phoneNumber, String address ) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        else if (contactId.length() > uuidLength) {
            throw new IllegalArgumentException("Contact ID cannot be longer than " + uuidLength + " characters");
        }
        else {
            this.contactId = contactId;
        }
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        else if (firstName.length() > firstNameLength) {
            throw new IllegalArgumentException("First name cannot be longer than " + firstNameLength + " characters");
        }
        else {
            this.firstName = firstName;
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        else if (lastName.length() > lastNameLength) {
            throw new IllegalArgumentException("Last name cannot be longer than " + lastNameLength + " characters");
        }
        else {
            this.lastName = lastName;
        }
        String regex = "[0-9]+";
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone Number cannot be null");
        }
        else if (phoneNumber.length() != phoneNumLength) {
            throw new IllegalArgumentException("Phone number length invalid. It must be " + phoneNumLength + " digits");
        } else if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("Phone number cannot contain letters");
        }
        else {
            this.phoneNumber = phoneNumber;
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        else if (address.length() > addressLength) {
            throw new IllegalArgumentException("Address cannot be longer than " + addressLength + " characters");
        }
        else {
            this.address = address;
        }
    }

    public String getContactId() {
        //System.out.println("ContactId number:" + contactId);
        return contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "["+contactId+","+firstName+","+lastName+","+phoneNumber+","+address+"]";
    }
}
