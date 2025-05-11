import java.util.ArrayList;
import java.util.List;

public class Course {
    private User chauffeur;
    private List<User> passagers;
    private Itinerary Itinerary;
    private Preferences preferences;

    // Constructeur
    public Course(User chauffeur, Itinerary Itinerary, Preferences preferences) {
        this.chauffeur = chauffeur;
        this.Itinerary = Itinerary;
        this.preferences = preferences;
        this.passagers = new ArrayList<>();
    }

    // Getters et Setters
    public User getChauffeur() {
        return chauffeur;
    }

    public List<User> getPassagers() {
        return passagers;
    }

    public Itinerary getItinerary() {
        return Itinerary;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    // Ajouter un passager si pas déjà présent
    public boolean ajouterPassager(User passager) {
        if (!passagers.contains(passager)) {
            passagers.add(passager);
            return true;
        }
        return false;
    }

    // Afficher la course
    public void afficherCourse() {
        System.out.println(" COURSE ");
        System.out.println("Chauffeur : " + chauffeur.getLastName() );
        Itinerary.afficherItinerary();
        preferences.afficherPreferences();
        System.out.println("Passagers :");
        for (User p : passagers) {
            System.out.println("- " + p.getLastName() );
        }
    }
}
