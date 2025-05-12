public class Student extends User implements Role {
    private String studentId;
    private String faculty;

    // ➤ Constructeur complet
    public Student(String id, String name, String studentId, String faculty) {
        super(id, name);
        this.studentId = studentId;
        this.faculty = faculty;
    }

    // ➤ Constructeur simplifié
    public Student(String id, String name, String faculty) {
        super(id, name);
        this.studentId = id;
        this.faculty = faculty;
    }

    @Override
    public void displayRoleInfo() {
        System.out.println("Role: Student");
        System.out.println("Student ID: " + studentId);
        System.out.println("Faculty: " + faculty);
    }

    public String getFaculty() {
        return faculty;
    }
}
