package StudentManagementSystem;

public class Student {
	int id,age;
	String name;
	double marks;
	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name2) {
		this.name = name2;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return " Id "+id+" Name "+name+" Age "+age+" Marks "+marks;
	}

	Student(int id, String name,int age,double marks){
		this.id=id;
		this.name=name;
		this.age=age;	
		this.marks=marks;
	}

}
