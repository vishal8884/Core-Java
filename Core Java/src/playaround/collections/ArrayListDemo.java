package playaround.collections;

import java.util.ArrayList;

public class ArrayListDemo {
  
    public static void main(String args[])
    {
  
        // Creating an empty ArrayList
        ArrayList<String> list = new ArrayList<String>();
  
        // Use add() method
        // to add elements in the list
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("10");
        list.add("20");
  
        // Displaying the list

        list.clone();
  
        // Creating another linked list and copying
        ArrayList sec_list = new ArrayList();
        sec_list = (ArrayList)list.clone();
  
        // Displaying the other linked list
        System.out.println("Second ArrayList is: " + sec_list);
    }
}