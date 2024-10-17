 
package it20b.balabat.queue;
 
import java.util.LinkedList;
import java.util.Queue;
public class IT20BBALABATQUEUE {
 
    public static void main(String[] args) {
       
        // Creating a queue using a LinkedList
        Queue<String> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");

        // Accessing and removing elements from the queue (FIFO)
        String firstElement = queue.poll(); // Removes and returns "Apple"
        String secondElement = queue.poll(); // Removes and returns "Banana"

        // Printing the remaining elements in the queue
        System.out.println("Remaining elements in the queue: " + queue);

        // Adding more elements to the queue
        queue.add("Date");
        queue.add("Eggplant");

        // Accessing and removing elements from the queue (FIFO)
        String thirdElement = queue.poll(); // Removes and returns "Cherry"

        // Printing the remaining elements in the queue
        System.out.println("Remaining elements in the queue: " + queue);
    }
} 
  