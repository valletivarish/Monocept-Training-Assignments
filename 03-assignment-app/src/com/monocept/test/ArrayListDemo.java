package com.monocept.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.monocept.model.Person;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the details of person " + (i + 1) + ": ");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            persons.add(new Person(name, age, address));
        }
        manipulateArray(persons, scanner);
        accessArray(persons);
        updateArray(persons, scanner);
        removeElement(persons);
        searchElement(persons, scanner);
        traverseArray(persons);
        clearArray(persons);
    }
    private static void clearArray(ArrayList<Person> persons) {
        System.out.println("\nClearing the ArrayList: ");
        System.out.println("\nUser - Clear all elements from the ArrayList.");
        persons.clear();
        System.out.println("\nUser - Check whether the array is cleared or not.");
        if (persons.size() == 0) {
            System.out.println("No elements are present in the array.");
        }
        if (persons.size() > 0) {
            System.out.println("Oops! Some elements are still in the array.");
        }
    }
    private static void traverseArray(ArrayList<Person> persons) {
        System.out.println("\nTraversing the array: ");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println("\nDetails of person " + (i + 1) + ": ");
            System.out.println(persons.get(i));
        }
        System.out.println("\nUser - Using enhanced for loop.");
        for (Person person : persons) {
            System.out.println(person);
        }
    }
    private static void searchElement(ArrayList<Person> persons, Scanner scanner) {
        System.out.println("\nSearching Elements: ");
        System.out.println("Enter the criteria you want to search for the person: \n1. Name \n2. Age \n3. Address");
        int criteria = scanner.nextInt();
        int count = 0;
        switch (criteria) {
            case 1:
                searchName(persons, scanner, count);
                break;
            case 2:
                searchAge(persons, scanner, count);
                break;
            case 3:
                searchAddress(persons, scanner, count);
        }
    }
    private static void searchAddress(ArrayList<Person> persons, Scanner scanner, int count) {
        System.out.println("Enter the address of the person: ");
        String address = scanner.nextLine();
        int index = 0;
        for (Person person : persons) {
            if (person.getAddress().equals(address)) {
                count++;
                index = persons.indexOf(person);
            }
        }
        handleSearchResult(persons, count, index);
    }
    private static void searchAge(ArrayList<Person> persons, Scanner scanner, int count) {
        System.out.println("Enter the age of the person: ");
        int age = scanner.nextInt();
        int index = 0;
        for (Person person : persons) {
            if (person.getAge() == age) {
                count++;
                index = persons.indexOf(person);
            }
        }
        handleSearchResult(persons, count, index);
    }
    private static void searchName(ArrayList<Person> persons, Scanner scanner, int count) {
        System.out.println("Enter the name of the person: ");
        String name = scanner.next();
        int index = 0;
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                count++;
                index = persons.indexOf(person);
            }
        }
        handleSearchResult(persons, count, index);
    }
    private static void handleSearchResult(ArrayList<Person> persons, int count, int index) {
        if (count > 1) {
            System.out.println("There are multiple persons...Please specify the other details you know so I could get the correct one.");
            return;
        }
        if (count == 0) {
            System.out.println("No person is found with these criteria.");
            return;
        }
        System.out.println("The person you are searching for is at position " + (index + 1) + ".");
        System.out.println("Here are the details of the person: ");
        System.out.println(persons.get(index));
    }
    private static void removeElement(ArrayList<Person> persons) {
        System.out.println("\nRemoving Elements: ");
        System.out.println("\nUser - Remove the first Person object from the ArrayList.");
        persons.remove(0);
        printAllPersons(persons);
        System.out.println("\nUser - Remove the Person object at the third position.");
        persons.remove(2);
        printAllPersons(persons);
    }
    private static void updateArray(ArrayList<Person> persons, Scanner scanner) {
        System.out.println("\nUpdating Elements: ");
        System.out.println("\nUser - Change the details of the second Person object in the ArrayList.");
        System.out.println("Please enter the details to update the second person: ");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        persons.set(1, new Person(name, age, address));
        printAllPersons(persons);
    }
    private static void accessArray(ArrayList<Person> persons) {
        System.out.println("\nAccessing Elements: ");
        printDetails(4, persons);
        printDetails(0, persons);
        printDetails(persons.size() - 1, persons);
    }
    private static void manipulateArray(ArrayList<Person> persons, Scanner scanner) {
        System.out.println("\nManipulating the ArrayList: ");
        System.out.println("Original array: ");
        printAllPersons(persons);
        System.out.println("\nUser - Add a new Person object to the beginning of the ArrayList.");
        addDetails(0, persons, scanner);
        printAllPersons(persons);
        System.out.println("\nUser - Add a new Person object to the end of the ArrayList.");
        addDetails(persons.size(), persons, scanner);
        printAllPersons(persons);
        System.out.println("\nUser - Insert a new Person object at the third position in the ArrayList.");
        addDetails(2, persons, scanner);
        printAllPersons(persons);
    }
    private static void printAllPersons(ArrayList<Person> persons) {
        int i = 1;
        for (Person person : persons) {
            System.out.println("\nDetails of person " + i + ": ");
            System.out.println(person);
            i++;
        }
    }
    private static void printDetails(int i, ArrayList<Person> persons) {
        System.out.println("\nDetails of Person at position " + (i + 1) + ": ");
        System.out.println(persons.get(i));
    }
    private static void addDetails(int i, ArrayList<Person> persons, Scanner scanner) {
        System.out.println("Enter the details of the person: ");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        persons.add(i, new Person(name, age, address));
    }
}