package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook; //wait to initialize

    public PhoneBook(Map<String, List<String>> map) { // given a map
        this.phonebook = map;

    }

    public PhoneBook() { //nullary constructor
        this(new TreeMap<>());
    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            phonebook.get(name).add(phoneNumber); ///see below
        } else {
            phonebook.put(name, new ArrayList<>());  //creating a new arraylist for phone numbers
            phonebook.get(name).add(phoneNumber); //get the List value and then add the phone number
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String s : phoneNumbers) {
            add(name, s);
        }
    }

    public void remove(String name) {
        if (hasEntry(name)) { //because we wrote this
            phonebook.remove(name);
        }
    }

    public Boolean hasEntry(String name, String phoneNumber) {

        if (phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber)) {
            return true;  // if the phone book contains the name and also the phone number
        }
        return false;
    }  //added method because test wants it

    public Boolean hasEntry(String name) {

        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        return new HashMap(phonebook);  //convert that to a hashmap because it's what the test wants
    }
}
