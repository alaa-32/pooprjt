public class Teacher extends User implements Role {
    private String teacherId;
    private String faculty;

    // ➤ Constructeur complet
    public Teacher(String id, String name, String teacherId, String faculty) {
        super(id, name);
        this.teacherId = teacherId;
        this.faculty = faculty;
    }

    // ➤ Constructeur simplifié
    public Teacher(String id, String name, String faculty) {
        super(id, name);
        this.teacherId = id; // On prend id comme identifiant par défaut
        this.faculty = faculty;
    }

    @Override
    public void displayRoleInfo() {
        System.out.println("Role: Teacher");
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Faculty: " + faculty);
    }

    public String getFaculty() {
        return faculty;
    }
}
