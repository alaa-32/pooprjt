public class main {
  public class MainAdministrationTest {
    public static void main(String[] args) {
        // Création de l'administration avec capacité max de 10 utilisateurs et 10 courses
        Administration admin = new Administration(10, 10);

        // Création de quelques utilisateurs
        Student s1 = new Student("Amine", "Boukhatem", "ETU001", 4.5f, "Chauffeur", "Informatique");
        Student s2 = new Student("Sami", "Benali", "ETU002", 3.0f, "Passager", "Informatique");
        Teacher t1 = new Teacher("Nadia", "Zerrouki", "ENS001", 4.8f, "Chauffeur", "Mathématiques");
        Staff a1 = new Staff("Ali", "Kacem", "ATS001", 2.5f, "Chauffeur", "Bibliothèque");

        // Ajout des utilisateurs à l'administration
        admin.addUser(s1);
        admin.addUser(s2);
        admin.addUser(t1);
        admin.addUser(a1);

        
        // Création de quelques courses
       // Course c1 = new Course("2025-05-07", s1); // course avec le student s1 comme chauffeur
       // Course c2 = new Course("2025-05-08", t1); // course avec l'enseignant t1
        //Course c3 = new Course("2025-05-07", a1); // course avec ATS

        // Marquer une course comme terminée
        //c2.setTerminee(true);

        // Ajout des courses à l'administration
        //admin.ajouterCourse(c1);
        //admin.ajouterCourse(c2);
        //admin.ajouterCourse(c3);  
       

        // Afficher les différentes informations
        admin.showOngoingTrips();
        admin.showDailyPlanning("2025-05-07");

        String[] semaine = {"2025-05-07", "2025-05-08"};
        admin.showWeeklyPlanning(semaine);

        admin.showTripHistory();
        admin.showStatistics();
        admin.mostActiveCategory();
        admin.mostActiveFaculty();
        admin.top10Drivers();

        // Simulation d'une mauvaise note
        SystemeEvaluation systeme = new SystemeEvaluation();
        systeme.passagerEvalueChauffeur(s2, s1, 1, "Conduite dangereuse");

        admin.showBlacklist();
        admin.banLowReputationUsers();
    }
} 

// NB : Les classes Course, Student, Teacher, Staff, Utilisateur, Evaluation, SystemeEvaluation
// doivent être déjà bien implémentées avec les bons constructeurs et méthodes (setTerminee, getFaculte, etc.).

  
}
