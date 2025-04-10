import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private float gpa;

    public Student(int id, String name, float gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public float getGpa() { return gpa; }

    public void setName(String name) { this.name = name; }
    public void setGpa(float gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}
