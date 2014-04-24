package com.cloudera.sa.examples.test;

import com.cloudera.sa.examples.tutorial.AddressBookProtos.AddressBook;
import com.cloudera.sa.examples.tutorial.AddressBookProtos.Person;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

class ListPeopleString {
  // Iterates though all people in the AddressBook and prints info about them.
  static void Print(AddressBook addressBook) {
    for (Person person: addressBook.getPersonList()) {
      System.out.println("Person ID: " + person.getId());
      System.out.println("  Name: " + person.getName());
      if (person.hasEmail()) {
        System.out.println("  E-mail address: " + person.getEmail());
      }

      for (Person.PhoneNumber phoneNumber : person.getPhoneList()) {
        switch (phoneNumber.getType()) {
          case MOBILE:
            System.out.print("  Mobile phone #: ");
            break;
          case HOME:
            System.out.print("  Home phone #: ");
            break;
          case WORK:
            System.out.print("  Work phone #: ");
            break;
        }
        System.out.println(phoneNumber.getNumber());
      }
    }
  }

  public static void main(String[] args) throws Exception {

    String base64Encoded = "CkIKB3ByYXRlZWsQexoUcHJ1bmd0YUBjbG91ZGVyYS5jb20iCAoGMTIzNDU2IgUKAzIxNCIFCgMyMTMiBwoDMjEzEAAKIQoEbGFycxCPBxoNdGVzdEBsYXJzLmNvbSIHCgMxMjMQAg==";

    byte[] decodedString = DatatypeConverter.parseBase64Binary( base64Encoded );

    // Read the existing address book.
    AddressBook addressBook =
      AddressBook.parseFrom( decodedString );

    Print(addressBook);
  }
}
