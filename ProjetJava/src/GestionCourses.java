import java.util.ArrayList;
import java.util.List;

public class GestionCourses {
    private List<Course> coursesDisponibles;

    // Constructeur
    public GestionCourses() {
        this.coursesDisponibles = new ArrayList<>();
    }

    //  Méthode 1 : Créer une course
    public boolean creerCourse(User chauffeur, Itinerary Itinerary, Preferences preferences) {
        if (!chauffeur.getStatut().equalsIgnoreCase("chauffeur")) {
            System.out.println("Erreur : L'User n'est pas un chauffeur.");
            return false;
        }

        Course nouvelleCourse = new Course(chauffeur, Itinerary, preferences);
        coursesDisponibles.add(nouvelleCourse);
        System.out.println("Course créée avec succès !");
        return true;
    }

    //  Méthode 2 : Chercher une course compatible
    public List<Course> chercherCourse(User passager, Itinerary ItineraryRecherche, Preferences preferencesRecherche) {
        List<Course> resultats = new ArrayList<>();

        if (!passager.getStatut().equalsIgnoreCase("passager")) {
            System.out.println("Erreur : L'User n'est pas un passager.");
            return resultats;
        }

        for (Course c : coursesDisponibles) {
            // Conditions simples de compatibilité (à améliorer si besoin)
            if (c.getItinerary().getPointDepart().equalsIgnoreCase(ItineraryRecherche.getPointDepart())
                && c.getPreferences().getGenderPreference().equalsIgnoreCase(preferencesRecherche.getSexeAccepte())
                && c.getPreferences().isMusicAllowed() == preferencesRecherche.isMusique()
                && c.getPreferences().isBaggageAllowed() == preferencesRecherche.isBaggageAllowed()) {
                resultats.add(c);
            }
        }

        return resultats;
    }

    // Méthode pour afficher toutes les courses
    public void afficherToutesLesCourses() {
        for (Course c : coursesDisponibles) {
            c.afficherCourse();
            System.out.println("--------------------");
        }
    }
}
