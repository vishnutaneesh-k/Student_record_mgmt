import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search by ID");
            System.out.println("6. Sort by GPA (Desc)");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // flush newline

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("GPA: ");
                    float gpa = sc.nextFloat();
                    manager.addStudent(new Student(id, name, gpa));
                    break;
                case 2:
                    manager.listStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New GPA: ");
                    float newGpa = sc.nextFloat();
                    if (!manager.updateStudent(uid, newName, newGpa))
                        System.out.println("Student not found.");
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    if (!manager.deleteStudent(did))
                        System.out.println("Student not found.");
                    break;
                case 5:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    Student found = manager.searchById(sid);
                    System.out.println(found != null ? found : "Student not found.");
                    break;
                case 6:
                    manager.sortByGpaDescending();
                    System.out.println("Sorted by GPA (Descending).");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
