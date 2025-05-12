import java.util.ArrayList;
import java.util.List;

public class GestionCourses {
    private List<Trip> tripsDisponibles;

    // Constructeur
    public GestionCourses() {
        this.tripsDisponibles = new ArrayList<>();
    }

    // Méthode 1 : Créer une course
    public boolean creerCourse(User chauffeur, Itinerary itinerary, Preferences preferences, String date) {
        if (chauffeur == null || itinerary == null || preferences == null || date == null) {
            System.out.println("Erreur : Paramètre invalide.");
            return false;
        }

        Trip nouvelleTrip = new Trip(chauffeur, itinerary, preferences, date);
        tripsDisponibles.add(nouvelleTrip);
        System.out.println("Course (Trip) créée avec succès !");
        return true;
    }

    // Méthode 2 : Chercher une course compatible
    public List<Trip> chercherCourse(User passager, Itinerary itineraryRecherche, Preferences preferencesRecherche) {
        List<Trip> resultats = new ArrayList<>();

        for (Trip t : tripsDisponibles) {
            if (t.getItinerary().getStartPoint().equalsIgnoreCase(itineraryRecherche.getStartPoint())
                    && t.getPreferences().getGenderPreference().equalsIgnoreCase(preferencesRecherche.getGenderPreference())
                    && t.getPreferences().isMusicAllowed() == preferencesRecherche.isMusicAllowed()
                    && t.getPreferences().isBaggageAllowed() == preferencesRecherche.isBaggageAllowed()) {
                resultats.add(t);
            }
        }

        return resultats;
    }

    // Méthode pour afficher toutes les courses disponibles
    public void afficherToutesLesCourses() {
        for (Trip t : tripsDisponibles) {
            t.showTripInfo();
            System.out.println("--------------------");
        }
    }
}
