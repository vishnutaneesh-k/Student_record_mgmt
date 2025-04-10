import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students;
    private final String FILE_NAME = "students.txt";

    public StudentManager() {
        students = loadFromFile();
    }

    // CREATE
    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    // READ
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // UPDATE
    public boolean updateStudent(int id, String newName, float newGpa) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setGpa(newGpa);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // SEARCH
    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // SORT
    public void sortByGpaDescending() {
        students.sort((a, b) -> Float.compare(b.getGpa(), a.getGpa()));
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Failed to save records: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<Student> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load records: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
