package playaround.other;

import ComparatorSorting.model.Student;

public class ObjectReference {
    public static void main(String[] args) {
        final Student s = new Student(1,"vishalll","N");
        Student s2 = s;

        s2.setFirstName("Vishal");

        System.out.println("Student 1 :: "+s);
        System.out.println("Student 2 :: "+s2);


    }
}
