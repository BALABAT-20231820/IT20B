/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it20b.balabat.linkedlist;

import java.util.LinkedList;
public class IT20BBALABATLINKEDLIST {

    public static void main(String[] args) {
      LinkedList<String> animals = new LinkedList<>();

// insertion
        animals.add("Dog");
        animals.addFirst("Cat");
        animals.addLast("Elephant");
        animals.add(1, "Lion");

        System.out.println("Linked List Original: " + animals);
        System.out.println(animals.size());

//  Seraching  
        if (animals.contains("Lion")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        boolean containslion = animals.contains("Lion");
        System.out.println(containslion);

//        Deletion
//        animals.remove();
//        animals.removeFirst();
//        animals.removeLast();
//        animals.remove(2);
//        System.out.println("LinkedList After Deletion: " + animals);
//        Insertion:    add(); addFirst();  addLast();  add(index, data);
//         Deletion:    remove();   removeFirst();  removeLast(); remove(index);
//          Searching operation:        contains(element); size();
    }

}