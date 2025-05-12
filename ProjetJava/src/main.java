import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // === INITIALISATION ===
        Administration admin = new Administration(20, 20);
        GestionCourses gestion = new GestionCourses();
        RatingSystem ratingSystem = new RatingSystem();

        // === CRÉATION D'UTILISATEURS ===
        Student s1 = new Student("ETU001", "Amine", "Informatique");
        Student s2 = new Student("ETU002", "Sami", "Physique");
        Teacher t1 = new Teacher("ENS001", "Nadia", "Mathématiques");
        Driver d1 = new Driver("DRV001", "Salah", "LIC123");
        Staff a1 = new Staff("ATS001", "Ali", "Bibliothèque");
        // Ajout dans l'administration
        admin.addUser(s1);
        admin.addUser(s2);
        admin.addUser(t1);
        admin.addUser(a1);
        admin.addUser(d1);

        // === PRÉFÉRENCES & ITINÉRAIRES ===
        Preferences prefs1 = new Preferences("mixed", true, true);
        Preferences prefs2 = new Preferences("mixed", true, false);
        Itinerary iti1 = new Itinerary("Bab Ezzouar", Arrays.asList("El Harrach", "Ain Naadja"));
        Itinerary iti2 = new Itinerary("El Harrach", Arrays.asList("Hussein Dey"));

        // === CRÉATION DE COURSES ===
        gestion.creerCourse(d1, iti1, prefs1, "2025-05-13");
        gestion.creerCourse(t1, iti2, prefs2, "2025-05-13");

        // === AFFICHER COURSES ===
        System.out.println("\n=== COURSES DISPONIBLES ===");
        gestion.afficherToutesLesCourses();

        // === RECHERCHE DE COURSE ===
        System.out.println("\n=== RECHERCHE POUR S1 ===");
        List<Trip> results = gestion.chercherCourse(s1, iti1, prefs1);
        if (!results.isEmpty()) {
            Trip selectedCourse = results.get(0);
            selectedCourse.addPassenger(s1);
            selectedCourse.addPassenger(s2);
            System.out.println("Passagers ajoutés à la course du chauffeur : " + selectedCourse.getDriver().getLastName());
        }

        // === MARQUER COMME TERMINÉ ===
        Trip course = results.get(0);
        course.markAsFinished();

        // === AFFICHAGE COURSE ===
        System.out.println("\n=== INFOS DE LA COURSE TERMINÉE ===");
        course.showTripInfo();

        // === NOTATION ===
        ratingSystem.rate(s1, d1, 5, "Excellent trajet !");
        ratingSystem.rate(s2, d1, 3, "Conduite correcte.");
        ratingSystem.rate(d1, s1, 4, "Bon passager");

        // === RÉPUTATIONS ===
        System.out.println("\nRéputation du chauffeur Salah : " + d1.getReputation());
        System.out.println("Réputation de l'étudiant Amine : " + s1.getReputation());

        // === STATISTIQUES ===
        System.out.println("\n=== STATISTIQUES ===");
        admin.showStatistics();
        admin.mostActiveCategory();
        admin.mostActiveFaculty();
        admin.top10Drivers();

        // === HISTORIQUE / BLACKLIST ===
        admin.showTripHistory();
        admin.showBlacklist();

        // === BANNIR UTILISATEURS À MAUVAISE RÉPUTATION ===
        System.out.println("\n=== BANNISSEMENT ===");
        admin.banLowReputationUsers();
    }
}
