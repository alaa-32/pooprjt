public class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    // Méthode pour chercher une course
    public boolean searchTrip(Trip trip, Itinerary preferredItinerary, Preferences preferredPreferences) {
        return trip.getItinerary().getStartPoint().equals(preferredItinerary.getStartPoint()) &&
               trip.getItinerary().getDropPoints().equals(preferredItinerary.getDropPoints()) &&
               trip.getPreferences().getGenderPreference().equals(preferredPreferences.getGenderPreference()) &&
               trip.getPreferences().isMusicAllowed() == preferredPreferences.isMusicAllowed() &&
               trip.getPreferences().isBaggageAllowed() == preferredPreferences.isBaggageAllowed();
    }
}
