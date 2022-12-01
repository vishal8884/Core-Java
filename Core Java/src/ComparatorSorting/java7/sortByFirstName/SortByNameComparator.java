package ComparatorSorting.java7.sortByFirstName;

import java.util.Comparator;

import ComparatorSorting.model.Student;

public class SortByNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
