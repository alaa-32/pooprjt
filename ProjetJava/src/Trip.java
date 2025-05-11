import java.util.ArrayList;
import java.util.List;

public class Trip {

    private User driver;
    private Itinerary itinerary;
    private Preferences preferences;
    private List<User> passengers;
    private String date; // ex: "2025-05-07"
    private boolean finished;

    public Trip(User driver, Itinerary itinerary, Preferences preferences, String date) {
        this.driver = driver;
        this.itinerary = itinerary;
        this.preferences = preferences;
        this.date = date;
        this.passengers = new ArrayList<>();
        this.finished = false;
    }

    public void addPassenger(User passenger) {
        passengers.add(passenger);
    }

    public boolean hasPassenger(User u) {
        return passengers.contains(u);
    }

    public void markAsFinished() {
        this.finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isInProgress(String currentDate) {
        return !finished && date.equals(currentDate);
    }

    public void showTripInfo() {
        System.out.println("=== Trip Info ===");
        System.out.println("Date       : " + date);
        System.out.println("Driver     : " + driver.getLastName());
        System.out.println("Start → Drop: " + itinerary.getStartPoint() + " → " + itinerary.getDropPoints());
        System.out.println("Preferences: Gender=" + preferences.getGenderPreference() +
                ", Music=" + preferences.isMusicAllowed() +
                ", Baggage=" + preferences.isBaggageAllowed());
        System.out.println("Passengers :");
        for (User u : passengers) {
            System.out.println("- " + u.getLastName());
        }
        System.out.println("Status     : " + (finished ? "Finished" : "Ongoing"));
    }

    public String getDate() {
        return date;
    }

    public User getDriver() {
        return driver;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public Preferences getPreferences() {
        return preferences;
    }
}
