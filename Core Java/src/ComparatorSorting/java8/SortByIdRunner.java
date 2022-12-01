package ComparatorSorting.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ComparatorSorting.java7.sortById.StudentIdComparator;
import ComparatorSorting.model.Student;

public class SortByIdRunner {

	public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
		
		for(int i=5;i<=10;i++) {
			students.add(new Student(i,"fName"+i,"lName"+i));
		}
		for(int i=0;i<=4;i++) {
			students.add(new Student(i,"fName"+i,"lName"+i));
		}
		System.out.println("---------------------------------------------before sort by id---------------------------------------");
		for(Student s : students) {
			System.out.println("student :: "+s);
		}
		
		//Working
//		Collections.sort(students, (o1,o2) -> {
//			if(o1.getId() > o2.getId()) {
//				return 1;
//			}
//			if(o1.getId() < o2.getId()) {
//				return -1;
//			}
//			return 0;
//		});
		
		//approach2...simplified
		
		Comparator<Student> sortByIdComparator = Comparator.comparing(s -> s.getId());
		Collections.sort(students,sortByIdComparator);
		
		
		System.out.println("---------------------------------------------after sort by id----------------------------------------------------");
		for(Student s : students) {
			System.out.println("student :: "+s);
		}
	}
}
