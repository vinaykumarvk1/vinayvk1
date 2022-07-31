package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImpl implements StudentManagementSystem{
	Scanner scan=new Scanner(System.in);
	LinkedHashMap<Integer, Student> db = new LinkedHashMap<Integer, Student>();

	@Override
	public void addStudent() {
		System.out.println("Enter Id, Name, Age and Marks");
		int id=scan.nextInt();
		String name=scan.next();
		int age=scan.nextInt();
		double marks=scan.nextDouble();

		//db.put(id,new Student(id,name,age,marks();
		Student std = new Student(id,name,age,marks);
		db.put(id, std);
		System.out.println("");
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter Student Id:");
		int id=scan.nextInt();//id ->key -> containskey()

		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student Record Deleted");
		}	
		else {
			try {
				throw new StudentNotFoundException("Student Data NotFound");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudent() {
		db.clear();
		System.out.println("Student Records Deleted");
	}

	@Override
	public void displayStudent() {
		System.out.println("ENter Student Id:");
		int id=scan.nextInt();

		if(db.containsKey(id)) {
			Student std =db.get(id);
			//			System.out.println(std);
			System.out.println("Id:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data NotFound");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent() {
		Set<Integer> setOfKeys =db.keySet();//creating a set of student Id's

		//for (int id:setOfKeys) {System.out.println(db.get(id));}

		for(int key : setOfKeys) {
			Student s=db.get(key); 
			System.out.print("Id:"+s.getId()+"+\tName:"+s.getName());
			System.out.println("\tage:"+s.getAge()+"\tMarks"+s.getMarks());

		}

	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id");
		int id=scan.nextInt();

		if(db.containsKey(id)) {
			Student s=db.get(id);
			System.out.println("1. Update Age\n2. Update Name\n3. Update Marks");
			System.out.println("Enter Choice");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=scan.nextInt();
				s.setAge(age);
				break;
			case 2:
				System.out.println("Enter Age");
				String name=scan.next();
				s.setName(name);
				break;
			case 3:
				System.out.println("Enter Age");
				int marks=scan.nextInt();
				s.setMarks(marks);
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data NotFound");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() {
		System.out.println("No. Of Student Records Present:"+db.size());
	}

	@Override
	public void sortStudent() {
		ArrayList<Student> l = new ArrayList<Student>();
		Set<Integer> s=db.keySet();
		for(int id:s) {
			l.add(db.get(id));	
		}
		
		System.out.println("1. Sort Based On Id\n2. Sort Based On Name\n3. Sort Based On Age\n4. Sort Based On Marks");
		System.out.println("Enter the choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(l,new SortStudentById());
			display(l);
			break;
		case 2:
			Collections.sort(l,new SortStudentByName());
			display(l);
			break;
		case 3:
			Collections.sort(l,new SortStudentByAge());
			display(l);
			break;
		case 4:
			Collections.sort(l,new SortStudentByMarks());
			display(l);
			break;
		default:
			System.out.println("Invalid Choice");
		}

	}
	
	private static void display(List<Student> l) {
		for(Student s :l) {
			System.out.println(s);
		}
	
	}
}
