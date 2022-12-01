package ComparatorSorting.java7.sortById;

import java.util.Comparator;

import ComparatorSorting.model.Student;

public class StudentIdComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getId() == o2.getId()) {
			return 0;
		}
		if(o1.getId() > o2.getId()) {
			return 1;
		}
		return -1;
	}

}
