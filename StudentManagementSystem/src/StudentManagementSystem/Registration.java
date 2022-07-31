package StudentManagementSystem;
import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("WELCOME TO SDBMS");
		System.out.println("----------------");

		StudentManagementSystem obj=new StudentManagementSystemImpl();

		while(true) {
			System.out.println("1. ADD STUDENT \n2. REMOVE STUDENT");
			System.out.println("3. REMOVE ALL STUDENT \n4. DISPLAY STUDENT");
			System.out.println("5. DISPLAY ALL STUDENT \n6. UPDATE STUDENT");
			System.out.println("7. COUNT STUDENT \n8. SORT STUDENT \n9. Exit");
			System.out.println("------------------");
			System.out.println("Enter Choice");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				obj.addStudent();
				break;

			case 2:
				obj.removeStudent();
				break;

			case 3:
				obj.removeAllStudent();
				break;

			case 4:
				obj.displayStudent();
				break;

			case 5:
				obj.displayAllStudent();
				break;

			case 6:
				obj.updateStudent();
				break;

			case 7:
				obj.countStudent();
				break;

			case 8:
				obj.sortStudent();
				break;

			case 9:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
			}
			System.out.println("-----------------------");
		}
	}
}
